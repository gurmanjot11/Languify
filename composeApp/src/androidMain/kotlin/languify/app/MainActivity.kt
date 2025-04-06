package languify.app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.Glide
import kotlin.jvm.java

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_loading)
        val btEnter = findViewById<ImageButton>(R.id.btEnter)
        Glide.with(this)
            .asGif()
            .load(R.drawable.animation_logo) // or URL/File
            .into(findViewById(R.id.ivAnimationLogo))

        btEnter.setOnClickListener {
            val intent = Intent(this, HomePage::class.java)
            startActivity(intent)

        }
    }

}
