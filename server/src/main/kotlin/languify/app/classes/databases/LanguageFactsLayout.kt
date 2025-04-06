package languify.app.classes.databases

import languify.Language

data class LanguageFacts(
    val id: Int,
    val language: String,
    //phrases to know
    val hello: String,
    val goodbye: String,
    val howAreYou: String,
    val numberOfSpeakers: String,
    //list
    val officialLanguageCountries: List<String>,
//    val widelySpokenInCountries: List<String>,
)


/*
    Determines the layout of the language facts
 */
class LanguageFactsLayout {

//    fun LanguageFactsLayout(){}

    fun retrieveFacts(language: Language) : LanguageFacts {
        return retrieveLanguageFact(language)
    }

}
