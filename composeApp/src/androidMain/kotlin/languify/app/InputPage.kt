package languify.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import languify.app.InputPDFPage
import languify.app.classes.BackendRequester
import languify.app.classes.experts.UniqueExpert

class InputPage:ComponentActivity()  {
    //var backend = BackendRequester()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_input)
        val inputText =findViewById<EditText>(R.id.mtTextInputBox)
        val buttonIdentify = findViewById<Button>(R.id.btText)


        buttonIdentify.setOnClickListener {
            val input = inputText.text.toString()
            if(input.isEmpty()){
                Toast.makeText(
                    this@InputPage,
                    "Please, do not enter empty input!",
                    Toast.LENGTH_SHORT
                ).show()
            }else{

                lifecycleScope.launch {
                    val result = BackendRequester().detectLanguage(input)
                    // Use the detected language
                    Log.i("DEBUGGING BACKEND", "INPUT")
                    Log.i("DEBUGGING BACKEND", input)

                    Log.i("DEBUGGING BACKEND", "GOT BACK FEEDBACK")
                    Log.i("DEBUGGING BACKEND", "---------------------------------------------")
                    Log.i("DEBUGGING BACKEND", result.languageName)
                    buttonIdentify.setText("Loading")
                    val intent = Intent(this@InputPage, DisplayPage::class.java)
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
    }
}