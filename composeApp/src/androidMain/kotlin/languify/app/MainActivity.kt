package languify.app

import android.content.Intent
import android.os.Bundle
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
        Glide.with(this)
            .asGif()
            .load(R.drawable.animation_logo) // or URL/File
            .into(findViewById(R.id.ivAnimationLogo))
    }
}
