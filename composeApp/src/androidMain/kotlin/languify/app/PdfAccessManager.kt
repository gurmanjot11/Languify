package languify.app
import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.Settings
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.InputStream

class PdfAccessManager(private val activity: ComponentActivity) {
    private val TAG = "PdfAccessManager"
    private val readPermissionRequestCode = 123

    // Callback to handle the result after PDF file access
    private var fileCallback: ((InputStream?, Exception?) -> Unit)? = null

    // Activity result launcher for file picker
    private val filePickerLauncher = activity.registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                try {
                    // Get input stream from the selected URI
                    val inputStream = activity.contentResolver.openInputStream(uri)
                    if (inputStream != null) {
                        Log.d(TAG, "PDF file selected and opened successfully")
                        fileCallback?.invoke(inputStream, null)
                    } else {
                        Log.e(TAG, "Failed to open input stream from selected URI")
                        fileCallback?.invoke(null, Exception("Failed to open PDF file"))
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Error accessing selected PDF: ${e.message}")
                    fileCallback?.invoke(null, e)
                }
            } ?: run {
                Log.e(TAG, "No file URI returned from picker")
                fileCallback?.invoke(null, Exception("No file selected"))
            }
        } else {
            Log.d(TAG, "File selection cancelled")
            fileCallback?.invoke(null, Exception("File selection cancelled"))
        }
    }

    /**
     * Opens file picker to select a PDF file
     */
    fun openPdfFromStorage(callback: (InputStream?, Exception?) -> Unit) {
        this.fileCallback = callback

        // Check storage permission
        if (hasStoragePermission()) {
            openFilePicker()
        } else {
            requestStoragePermission()
        }
    }

    /**
     * Open the system file picker
     */
    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "application/pdf"
        }
        filePickerLauncher.launch(intent)
    }

    /**
     * Check if the app has storage permission
     */
    private fun hasStoragePermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Environment.isExternalStorageManager()
        } else {
            ContextCompat.checkSelfPermission(
                activity,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    /**
     * Request storage permission
     */
    private fun requestStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            try {
                val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                val uri = Uri.fromParts("package", activity.packageName, null)
                intent.data = uri
                activity.startActivity(intent)
            } catch (e: Exception) {
                val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
                activity.startActivity(intent)
            }
        } else {
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                readPermissionRequestCode
            )
        }
    }

    /**
     * Handle permission result
     */
    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == readPermissionRequestCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openFilePicker()
            } else {
                Log.e(TAG, "Storage permission denied")
                fileCallback?.invoke(null, Exception("Storage permission denied"))
            }
        }
    }
}