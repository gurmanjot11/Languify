package languify.app.classes

import android.util.Log
import languify.app.classes.experts.ExpertManager
import languify.Language
import languify.app.classes.databases.LanguageFacts
import languify.app.classes.databases.LanguageFactsDatabase
import languify.app.classes.databases.LanguageSyntaxDatabase

class BackendRequester {

    private val syntaxDatabase : LanguageSyntaxDatabase = LanguageSyntaxDatabase()
    private val factsDatabase : LanguageFactsDatabase = LanguageFactsDatabase()
    private val textObtainer = TextObtainer()
    private val expertManager: ExpertManager = ExpertManager()


    suspend fun detectLanguage(input: String) : LanguageFacts {
        val text : Text = textObtainer.stringToTextObject(input)
        Log.i("DEBUGGING BACKEND", "text value" )
        Log.i("DEBUGGING BACKEND", text.toString())
        val language : Language = expertManager.determineLanguage(text,syntaxDatabase)
        Log.i("DEBUGGING BACKEND", "text value" )
        Log.i("DEBUGGING BACKEND", language.toString())
        val factsForDisplay : LanguageFacts = factsDatabase.getLanguageFacts(language)
        Log.i("DEBUGGING BACKEND", "text value" )
        Log.i("DEBUGGING BACKEND", factsForDisplay.toString())
        return factsForDisplay

    }
}