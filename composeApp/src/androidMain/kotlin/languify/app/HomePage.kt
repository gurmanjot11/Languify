package languify.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity


class HomePage:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_home)
        val btText = findViewById<Button>(R.id.btText)
        val btPDF = findViewById<Button>(R.id.btPDF)
        val btIMG = findViewById<Button>(R.id.btIMG)

        btText.setOnClickListener {
            val intent = Intent(this, InputPage::class.java)
            startActivity(intent)
        }

        btPDF.setOnClickListener {
            val intent = Intent(this, InputPDFPage::class.java)
            startActivity(intent)
        }

        btIMG.setOnClickListener {
            val intent = Intent(this, ImageTextExtractor::class.java)
            startActivity(intent)
        }

    }



}