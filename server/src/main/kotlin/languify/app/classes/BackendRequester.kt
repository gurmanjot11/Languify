import languify.app.classes.experts.ExpertManager
import languify.Language
import languify.app.classes.Text
import languify.app.classes.TextObtainer
import languify.app.classes.databases.LanguageFacts
import languify.app.classes.databases.LanguageFactsLayout

class BackendRequester {
    //obtain from front end


    //this will return language facts
    //implemented

    fun detectLanguage(input: String) {
        val textObtainer: TextObtainer = TextObtainer()
        val text : Text = textObtainer.stringToTextObject(input)

        val expertManager: ExpertManager = ExpertManager()
        val language: Language = expertManager.determineLanguage(text)

        val languageFactsLayout = LanguageFactsLayout()
        val facts: LanguageFacts = languageFactsLayout.retrieveFacts(language)

        //send to front end

        //return

    }
}