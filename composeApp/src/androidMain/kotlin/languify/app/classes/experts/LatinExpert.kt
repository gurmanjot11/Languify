package languify.app.classes.experts

import languify.Language
import languify.app.classes.Text
import languify.app.classes.databases.LanguageSyntaxDatabase
import com.detectlanguage.DetectLanguage

import java.io.File
import java.util.Properties
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// English, French, Spanish, French, portugese, german, turkish, polish, vietnamese
class LatinExpert: Expert {
    override suspend fun guessLanguage(text: Text, syntaxDatabase: LanguageSyntaxDatabase): Language {
        return withContext(Dispatchers.IO) {
            try {
                val apiKey = loadApiKey()
                DetectLanguage.apiKey = apiKey

                val result = DetectLanguage.simpleDetect(text.getString())
                val lang = Language.toLanguage(result)

                checkLanguage(lang ?: Language.NONE)
            } catch (e: Exception) {
                Language.NONE
            }
        }
    }


    private fun checkLanguage(language: Language): Language{
        return when (language) {
            Language.ENGLISH,
            Language.SPANISH,
            Language.FRENCH,
            Language.PORTUGUESE,
            Language.GERMAN,
            Language.VIETNAMESE,
            Language.TURKISH,
            Language.POLISH -> language
            else -> Language.NONE
        }
    }

    private fun loadApiKey(): String? {
        val properties = Properties()
        val file = File("local.properties")
        if (file.exists()) {
            properties.load(file.inputStream())
            return properties.getProperty("API_KEY")
        }
        return null
    }
}
