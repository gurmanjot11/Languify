package languify.app.classes

import languify.app.classes.experts.ExpertManager
import languify.Language
import languify.app.classes.databases.LanguageFacts
import languify.app.classes.databases.LanguageFactsDatabase
import languify.app.classes.databases.LanguageSyntaxDatabase
import languify.app.classes.databases.Result
import languify.app.classes.databases.ResultLog

class BackendRequester {

    private val syntaxDatabase : LanguageSyntaxDatabase = LanguageSyntaxDatabase()
    private val factsDatabase : LanguageFactsDatabase = LanguageFactsDatabase()
    private val textObtainer = TextObtainer()
    private val resultLog: ResultLog = ResultLog()
    private val expertManager: ExpertManager = ExpertManager(resultLog)


    fun detectLanguage(input: String) : LanguageFacts {
        val text : Text = textObtainer.stringToTextObject(input)
        val result: Result = expertManager.determineLanguage(text,syntaxDatabase)
        val language : Language = result.getOverallResult()
        val factsForDisplay : LanguageFacts = factsDatabase.getLanguageFacts(language)
        return factsForDisplay

    }
}