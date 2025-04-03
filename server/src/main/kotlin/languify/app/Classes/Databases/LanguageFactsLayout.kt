package languify

import languify.app.Classes.Databases.languageFactsDatabaseItems
import languify.app.Classes.Databases.retrieveLanguageFact

data class LanguageFacts(
    val id: Int,
    val language: String,
    //phrases to know
    val hello: String,
    val goodbye: String,
    val howAreYou: String,
    val numberOfSpeakers: Int,
    //list
    val officialLanguageCountries: List<String>,
    val widelySpokenInCountries: List<String>,
)


/*
    Determines the layout of the language facts
 */
class LanguageFactsLayout {

//    fun LanguageFactsLayout(){}

    fun retrieveFacts(language: Language) : LanguageFacts {
        return retrieveLanguageFact(language.toString())
    }

}
