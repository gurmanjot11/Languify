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
                val intent = Intent(this, DisplayPage::class.java)
                //val backendResponse = backend.detectLanguage(input)
                intent.putExtra("user_input_text",input)
                startActivity(intent)
            }
        }
    }
}