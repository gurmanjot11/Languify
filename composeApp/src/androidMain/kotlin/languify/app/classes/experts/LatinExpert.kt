package languify.app.classes.experts

import languify.Language
import languify.app.classes.Text
import languify.app.classes.databases.LanguageSyntaxDatabase


class LatinExpert: Expert {
    override fun guessLanguage(text: Text, syntaxDatabase : LanguageSyntaxDatabase): Language {
        return Language.NONE
    }
}
