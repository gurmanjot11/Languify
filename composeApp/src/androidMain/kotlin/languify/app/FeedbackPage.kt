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
import languify.app.InputPage
import languify.app.classes.BackendRequester

class FeedbackPage:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_feedback)
        val feedbackText =findViewById<EditText>(R.id.mtTextFeedBackBox)
        val buttonFeedbackPage = findViewById<Button>(R.id.btFeedBackGoBackHome)
        val btHomeBUtton = findViewById<Button>(R.id.homeButton)

        buttonFeedbackPage.setOnClickListener {
            val input = feedbackText.toString()
            if(input == ""){
                Toast.makeText(
                    this@FeedbackPage,
                    "Please, do not enter empty input!",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                buttonFeedbackPage.setText("Submitted!")
                }
        }
        btHomeBUtton.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
    }

}