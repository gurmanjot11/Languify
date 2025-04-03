package languify.app

import android.os.Bundle

import androidx.activity.ComponentActivity

class InputPage:ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_input)
    }
}