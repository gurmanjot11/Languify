package languify.app

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import languify.app.classes.BackendRequester

class InputPage:ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_input)
        val inputText =findViewById<EditText>(R.id.mtTextInputBox)
        val buttonIdentify = findViewById<Button>(R.id.btText)


        buttonIdentify.setOnClickListener {
            val input = inputText.toString()
            if(input == ""){
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
                }
                buttonIdentify.setText("Loading")
            }
        }
    }

    fun sendBackendInput(input: String) {

    }
}