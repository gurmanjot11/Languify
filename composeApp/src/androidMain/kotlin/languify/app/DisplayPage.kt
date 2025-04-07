package languify.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import languify.Language

class DisplayPage:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_display)


        val id = intent.getIntExtra("ID", 0)
        val languageCode = intent.getStringExtra("LANGUAGE_CODE") ?: "NONE"
        val language = Language.valueOf(languageCode) // Convert back to enum
        val languageName = intent.getStringExtra("LANGUAGE_NAME") ?: ""
        val hello = intent.getStringExtra("HELLO") ?: ""
        val goodbye = intent.getStringExtra("GOODBYE") ?: ""
        val howAreYou = intent.getStringExtra("HOW_ARE_YOU") ?: ""
        val numberOfSpeakers = intent.getStringExtra("NUMBER_OF_SPEAKERS") ?: ""
        val officialCountries = intent.getStringArrayExtra("OFFICIAL_COUNTRIES")?.toList() ?: emptyList()

        val tvLanguage = findViewById<TextView>(R.id.identifiedLanguage)
        val tvLanguage2 = findViewById<TextView>(R.id.language)
        val tvHello = findViewById<TextView>(R.id.helloLanguage)
        val tvGoodbye = findViewById<TextView>(R.id.goodbyeLanguage)
        val tvHowareyou = findViewById<TextView>(R.id.howAreYouLanguage)
        val tvNumberOfSpeaker = findViewById<TextView>(R.id.numberOfSpeakers)
        val tvOfficialCountries= findViewById<TextView>(R.id.regionSpoken)

        tvLanguage.setText(languageName)
        tvLanguage2.setText(languageName)
        tvHello.setText(hello)
        tvGoodbye.setText(goodbye)
        tvHowareyou.setText(howAreYou)
        tvNumberOfSpeaker.setText(numberOfSpeakers)
        tvOfficialCountries.setText(officialCountries.toString())

        val btHomeBUtton = findViewById<Button>(R.id.homeButton)
        val btYes = findViewById<Button>(R.id.yesButton)
        val btNo = findViewById<Button>(R.id.noButton)

        btYes.setOnClickListener {
            btYes.setBackgroundColor(0xFF00FF00.toInt())
        }

        btNo.setOnClickListener {
            btNo.setBackgroundColor(0xFFFF0000.toInt())
        }

        btHomeBUtton.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

    }
}