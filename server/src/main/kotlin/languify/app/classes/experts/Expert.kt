package languify.app.classes.experts

import languify.Language
import languify.app.classes.Text

interface Expert {
    fun guessLanguage(text: Text): Language
}
