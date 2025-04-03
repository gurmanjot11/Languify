package languify.app.classes.experts

import languify.Language
import languify.app.classes.Text


//gurman code
class ArabicExpert: Expert {
    override fun guessLanguage(text: Text): Language {
        return Language.NONE
    }
}
