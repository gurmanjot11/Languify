package languify.app

import android.os.Bundle

import androidx.activity.ComponentActivity
import languify.app.classes.BackendRequester

class InputPage:ComponentActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_input)
    }

    fun getBackend() {
        val backend : BackendRequester = BackendRequester()
        backend.detectLanguage("WHAT EVER STRING YOU WANT")
    }
}