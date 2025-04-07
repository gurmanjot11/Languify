package languify.app.classes.experts

import android.util.Log
import languify.app.BuildConfig
import languify.Language
import languify.app.classes.Text
import languify.app.classes.databases.LanguageSyntaxDatabase
import com.detectlanguage.DetectLanguage

import java.io.File
import java.util.Properties
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.FileNotFoundException

// English, French, Spanish, French, portugese, german, turkish, polish, vietnamese
class LatinExpert: Expert {

    override suspend fun guessLanguage(text: Text, syntaxDatabase: LanguageSyntaxDatabase): Language {
        return withContext(Dispatchers.IO) {
            try {
                val apiKey = BuildConfig.DETECTLANGUAGE_API_KEY
                DetectLanguage.apiKey = apiKey
//                val apiKey = loadApiKey()
//                DetectLanguage.apiKey = apiKey

                val result = DetectLanguage.simpleDetect(text.getString())
//                Log.i("DEBUGGING BACKEND".)

                Log.i("DEBUGGING BACKEND", "DETECT LANGUAGE RESULT" )
                Log.i("DEBUGGING BACKEND", "---------------------------------------------" )
                Log.i("DEBUGGING BACKEND", result )
                val lang = Language.toLanguage(result)

                checkLanguage(lang ?: Language.NONE)
            } catch (e: Exception) {
                Log.i("DEBUGGING BACKEND", e.toString() )

                Language.NONE
            }
        }
    }


    private fun checkLanguage(language: Language): Language{
        if (language.equals(Language.ENGLISH)){
            return Language.ENGLISH}
        else if (language.equals(Language.SPANISH)){
            return Language.SPANISH}
        else if (language.equals(Language.FRENCH)){
            return Language.FRENCH}
        else if (language.equals(Language.PORTUGUESE)){
                return Language.PORTUGUESE}
        else if (language.equals(Language.GERMAN)){
            return Language.GERMAN}
        else if (language.equals(Language.VIETNAMESE)){
            return Language.VIETNAMESE}
        else if (language.equals(Language.TURKISH)){
            return Language.TURKISH}
        else if (language.equals(Language.POLISH)){
            return Language.POLISH}
        else{
            Log.i("DEBUGGING BACKEND", "NONE")
            return Language.NONE}

    }

    private fun loadApiKey(): String? {
        val properties = Properties()
        val file = File("local.properties")
        if (file.exists()) {
            properties.load(file.inputStream())
            Log.i("DEBUGGING BACKEND", "I FOUND IT???")
            return properties.getProperty("API_KEY") ?: throw IllegalArgumentException("API_KEY not found in local.properties")
        } else {
            Log.i("DEBUGGING BACKEND", "DID I FIND IT")
            throw FileNotFoundException("local.properties file not found")
        }
    }
}
