package languify.app

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.pdftron.pdf.PDFDoc
import com.pdftron.pdf.PDFNet
import com.pdftron.pdf.TextExtractor
import com.pdftron.pdf.config.PDFNetConfig
import languify.app.classes.BackendRequester
import java.io.InputStream

class InputPDFPage: ComponentActivity() {
    private lateinit var pdfAccessManager: PdfAccessManager
    lateinit var inputStream : InputStream

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        try {
            PDFNet.initialize(this, 0, "")
        } catch (e: Exception) {
            Log.e("PDFTron", "Error initializing PDFNet: ${e.message}")
            Toast.makeText(this, "Failed to initialize PDF library", Toast.LENGTH_LONG).show()
            finish() // Close the activity if initialization fails
            return
        }
        setContentView(R.layout.page_pdf_input)
        val inputText =findViewById<EditText>(R.id.mtPDFTextInputBox)
        val buttonIdentify = findViewById<Button>(R.id.btExtract)
        val buttonSelectPdf = findViewById<Button>(R.id.btSelectPdf)
        pdfAccessManager = PdfAccessManager(this)

        buttonSelectPdf.setOnClickListener {
            selectPdfFromStorage()
        }

        buttonIdentify.setOnClickListener {
            val inputStream =this.inputStream
            try {
                val doc = PDFDoc(inputStream)
                val page = doc.getPage(1)

                val txt = TextExtractor()
                txt.begin(page!!)  // Read the page.

                // Create a StringBuilder to build the extracted text
                val extractedText = StringBuilder()

                var word: TextExtractor.Word
                var line: TextExtractor.Line = txt.firstLine
                while (line.isValid) {
                    word = line.firstWord
                    while (word.isValid) {
                        // Append each word to our text
                        extractedText.append(word.string)
                        extractedText.append(" ")  // Add a space between words
                        word = word.nextWord
                    }
                    extractedText.append("\n")  // Add a newline at the end of each line
                    line = line.nextLine
                }

                Log.i("TESTINGPDF", extractedText.toString())
                inputText.setText(extractedText.toString())
                //sendBackendInput(extractedText.toString())
            } catch (e: Exception) {
                // Handle any exceptions
                e.printStackTrace()
                Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun sendBackendInput(input: String) {
        val backend : BackendRequester = BackendRequester()
        backend.detectLanguage(input)
    }

    private fun selectPdfFromStorage() {
        pdfAccessManager.openPdfFromStorage { inputStream, error ->
            if (error != null) {
                Log.e("PDFAccess", "Error: ${error.message}")
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_LONG).show()
            } else if (inputStream != null) {
                this.inputStream = inputStream
            }
        }
    }
}