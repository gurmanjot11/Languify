package languify.app

import android.os.Bundle
import androidx.activity.ComponentActivity

class DisplayPage:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_display)
        //val user_input = intent2.getStringExtra("user_input_text")
        //println(user_input)
    }
}