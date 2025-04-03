package languify.app

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class HomePage:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_home)

    }
}