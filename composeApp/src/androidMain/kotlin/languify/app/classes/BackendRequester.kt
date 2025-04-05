package languify.app.classes

import languify.app.classes.experts.ExpertManager
import languify.Language
import languify.app.classes.databases.LanguageFacts
import languify.app.classes.databases.LanguageSyntaxDatabase

class BackendRequester {

    var syntaxDatabase : LanguageSyntaxDatabase = LanguageSyntaxDatabase()


    fun detectLanguage(input: String) : String {

        val textObtainer = TextObtainer()
        val text : Text = textObtainer.stringToTextObject(input)

        val expertManager: ExpertManager = ExpertManager()
        val language: Language = expertManager.determineLanguage(text)

        val languageFactsLayout = LanguageFacts()
        val facts: LanguageFacts = languageFactsLayout.retrieveFacts(language)

        //send to front end

//        return facts
//        return Language.ENGLISH
        return "HI"

    }
}