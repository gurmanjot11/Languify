package languify.app

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import kotlinx.coroutines.launch
import languify.app.InputPDFPage
import languify.app.classes.BackendRequester

class ImageTextExtractor : ComponentActivity() {
    private val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var captureBtn: Button
    private lateinit var detectBtn: Button
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private lateinit var imageBitmap: Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_image_input)

        captureBtn = findViewById(R.id.capture)
        detectBtn = findViewById(R.id.detect)
        imageView = findViewById(R.id.image_view)
        textView = findViewById(R.id.text_display)
        val buttonIdentifyReal = findViewById<Button>(R.id.btIdentify)

        captureBtn.setOnClickListener {
            dispatchTakePictureIntent()
        }

        detectBtn.setOnClickListener {
            detectTextFromImage()
        }
        buttonIdentifyReal.setOnClickListener {
            lifecycleScope.launch {
                val result = BackendRequester().detectLanguage(textView.text.toString())
                val intent = Intent(this@ImageTextExtractor, DisplayPage::class.java)
                intent.putExtra("ID", result.id)
                intent.putExtra("LANGUAGE_CODE", result.language.name) // Assuming Language is an enum
                intent.putExtra("LANGUAGE_NAME", result.languageName)
                intent.putExtra("HELLO", result.hello)
                intent.putExtra("GOODBYE", result.goodbye)
                intent.putExtra("HOW_ARE_YOU", result.howAreYou)
                intent.putExtra("NUMBER_OF_SPEAKERS", result.numberOfSpeakers)
                intent.putExtra("OFFICIAL_COUNTRIES", result.officialLanguageCountries.toTypedArray())
                startActivity(intent)
            }
        }

    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: Exception) {
            Log.e("ImageTextExtractor", "Error starting camera: ${e.message}")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val extras = data?.extras
            imageBitmap = extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }

    private fun detectTextFromImage() {
        // Check if imageBitmap is initialized
        if (!::imageBitmap.isInitialized) {
            textView.text = "Please capture an image first"
            return
        }

        // Create InputImage object for ML Kit
        val inputImage = InputImage.fromBitmap(imageBitmap, 0)

        // Get an instance of TextRecognizer
        val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

        // Process the image and detect text
        recognizer.process(inputImage)
            .addOnSuccessListener { visionText ->
                // Task completed successfully
                displayTextFromImage(visionText.text)
            }
            .addOnFailureListener { e ->
                // Task failed with an exception
                Toast.makeText(this@ImageTextExtractor, "Error: ${e.message}", Toast.LENGTH_LONG).show()
                Log.d("Error:", e.message.toString())
            }
    }

    private fun displayTextFromImage(text: String) {
        if (text.isEmpty()) {
            textView.text = "No text detected!"
        } else {
            textView.text = text
        }
    }
}