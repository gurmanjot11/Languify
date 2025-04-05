package languify.app.classes

import languify.app.classes.experts.ExpertManager
import languify.Language
import languify.app.classes.databases.LanguageFacts
import languify.app.classes.databases.LanguageFactsDatabase
import languify.app.classes.databases.LanguageSyntaxDatabase

class BackendRequester {

    private var syntaxDatabase : LanguageSyntaxDatabase = LanguageSyntaxDatabase()
    private var factsDatabase : LanguageFactsDatabase = LanguageFactsDatabase()
    private val textObtainer = TextObtainer()
    private val expertManager: ExpertManager = ExpertManager()


    fun detectLanguage(input: String) : LanguageFacts {
        val text : Text = textObtainer.stringToTextObject(input)
        val language : Language = expertManager.determineLanguage(text)
        val factsForDisplay : LanguageFacts = factsDatabase.getLanguageFacts(language)
        return factsForDisplay

    }
}