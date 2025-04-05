package languify.app.classes.experts

import languify.Language
import languify.app.classes.Text
import languify.app.classes.databases.LanguageSyntaxDatabase

interface Expert {
    fun guessLanguage(text: Text, syntaxDatabase: LanguageSyntaxDatabase): Language
}
