package languify.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

import androidx.activity.ComponentActivity

class HomePage:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_home)
        val btText = findViewById<Button>(R.id.btText)
        btText.setOnClickListener {
            val intent = Intent(this, InputPage::class.java)
            startActivity(intent)
        }
    }
}