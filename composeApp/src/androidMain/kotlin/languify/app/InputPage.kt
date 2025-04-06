package languify.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.activity.ComponentActivity
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
                sendBackendInput(input)
                buttonIdentify.setText("Loading")
            }
        }
    }

    fun sendBackendInput(input: String) {
//        val backend : BackendRequester = BackendRequester()
//        backend.detectLanguage(input)
    }
}