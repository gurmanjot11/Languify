package languify.app.classes.databases

import languify.Language

data class LanguageFacts(
    val id: Int,
    val language: Language,
    val languageName: String,
    //phrases to know
    val hello: String,
    val goodbye: String,
    val howAreYou: String,
    //fun facts
    val numberOfSpeakers: String,
    val officialLanguageCountries: List<String>
)
