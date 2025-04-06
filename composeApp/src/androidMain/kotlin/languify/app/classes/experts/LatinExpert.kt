package languify.app.classes.experts

import languify.Language
import languify.app.classes.Text
import languify.app.classes.databases.LanguageSyntaxDatabase

import java.io.File
import java.util.Properties

import com.detectlanguage.DetectLanguage
// English, French, Spanish, French, portugese, german, turkish, polish, vietnamese
class LatinExpert: Expert {
    override fun guessLanguage(text: Text, syntaxDatabase: LanguageSyntaxDatabase): Language {
        Thread {
            try {
                val apiKey = loadApiKey()
                DetectLanguage.apiKey = apiKey
            } catch (e: Exception) {
                //Language.NONE
                error("failed to load api for latin expert")
            }
        }.start()
        val result = DetectLanguage.simpleDetect(text.getString())
        val lang = Language.toLanguage(result)

        try {
            val resultNotNull: Language = lang!!
            return checkLanguage(resultNotNull)
        } catch (npe: NullPointerException) {
            return Language.NONE
        }
    }


    private fun checkLanguage(language: Language): Language{
        if (language.equals(Language.ENGLISH)){
            return Language.ENGLISH
        }
        else if (language.equals(Language.SPANISH)){
            return Language.SPANISH
        }
        else if (language.equals(Language.FRENCH)){
            return Language.FRENCH
        }
        else if (language.equals(Language.PORTUGUESE)){
            return Language.PORTUGUESE
        }
        else if (language.equals(Language.GERMAN)){
            return Language.GERMAN
        }
        else if (language.equals(Language.VIETNAMESE)){
            return Language.VIETNAMESE
        }
        else if (language.equals(Language.TURKISH)){
            return Language.TURKISH
        }
        else if (language.equals(Language.POLISH)){
            return Language.POLISH
        }
        else{
            return Language.NONE
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
