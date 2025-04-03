package languify.app.classes.experts

import languify.Language
import languify.app.classes.Text


class LatinExpert: Expert {
    override fun guessLanguage(text: Text): Language {
        return Language.NONE
    }
}
