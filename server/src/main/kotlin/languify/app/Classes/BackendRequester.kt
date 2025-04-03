import languify.ExpertManager
import languify.Language
import languify.Text
import languify.TextObtainer

class BackendRequester {
    //obtain from front end


    //this will return language facts
    //implemented

    fun detectLanguage(input: String) {
        val textObtainer: TextObtainer = TextObtainer()
        val text : Text = textObtainer.stringToTextObject(input)

        val expertManager: ExpertManager = ExpertManager()
        val language: Language = expertManager.determineLanguage(text)

        //Databases.LanguageFactsLayout.obtainFacts(language)
        //send to front end

        //return

    }
}