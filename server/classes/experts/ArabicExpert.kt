package languify.app.classes.experts

import languify.Language
import languify.app.classes.Text
import languify.app.classes.databases.LanguageSyntaxDatabase
import com.detectlanguage.DetectLanguage

import java.io.File
import java.util.Properties
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArabicExpert: Expert {

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

    private suspend fun checkLanguage(language: Language): Language {
        return when (language) {
            Language.ARABIC -> Language.ARABIC
            Language.PERSIAN -> Language.PERSIAN
            Language.URDU -> Language.URDU
            Language.KURDISH -> Language.KURDISH
            Language.PASHTO -> Language.PASHTO
            else -> Language.NONE
        }
    }

    private suspend fun loadApiKey(): String? {
        val properties = Properties()
        val file = File("local.properties")
        if (file.exists()) {
            properties.load(file.inputStream())
            return properties.getProperty("API_KEY")
        }
        return null
    }
}