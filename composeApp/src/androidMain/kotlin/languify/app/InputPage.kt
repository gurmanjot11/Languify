package languify.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import androidx.activity.ComponentActivity
import languify.app.classes.BackendRequester
import languify.app.classes.experts.UniqueExpert

class InputPage:ComponentActivity()  {
    //var backend = BackendRequester()
    //var uniqueExpert = UniqueExpert()

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
                buttonIdentify.setText("Loading")
                val intent = Intent(this, DisplayPage::class.java)
                //val backendResponse = backend.detectLanguage(input)
                intent.putExtra("user_input_text",input)
                startActivity(intent)
            }
        }
    }

    //fun sendBackendInput(input: String) {
    //    val backend : BackendRequester = BackendRequester()
    //    backend.detectLanguage(input)
    //}
}