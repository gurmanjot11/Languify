import languify.ExpertManager
import languify.Language
import languify.LanguageFacts
import languify.Text
import languify.TextObtainer
import languify.LanguageFactsLayout

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