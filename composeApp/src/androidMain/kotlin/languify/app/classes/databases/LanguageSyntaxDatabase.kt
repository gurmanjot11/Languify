package languify.app.classes.databases

import languify.Language
import languify.Script
import languify.app.classes.Text

class LanguageSyntaxDatabase {
    private var languagesInDatabase = mutableListOf<LanguageSyntax>()
    private var nextID = 1

    init {
        addLanguage(Language.KOREAN, Script.UNIQUE, 0, 0)
        addLanguage(Language.ARMENIAN, Script.UNIQUE, 0, 0)
        addLanguage(Language.GEORGIAN, Script.UNIQUE, 0, 0)
        addLanguage(Language.SINHALA, Script.UNIQUE, 0, 0)
        addLanguage(Language.HEBREW, Script.UNIQUE, 0, 0)
        addLanguage(Language.INUKTITUT, Script.UNIQUE, 0, 0)
        addLanguage(Language.CHEROKEE, Script.UNIQUE, 0, 0)
        addLanguage(Language.TAMIL, Script.UNIQUE, 0, 0)
        addLanguage(Language.KHMER, Script.UNIQUE, 0, 0)
    }

    //figure out how to make some of this stuff mutable
    private fun addLanguage(newName: Language, newCategory: Script, newUnicodeRangeUpper: Byte, newUnicodeRangeLower: Byte): LanguageSyntax
    {
        val newLanguage = LanguageSyntax(
            id = nextID++,
            name = newName,
            category = newCategory,
            unicodeRange = byteArrayOf(newUnicodeRangeUpper, newUnicodeRangeLower)
        )
        languagesInDatabase.add(newLanguage)
        return newLanguage
    }

    //this may have a bug for comparing enums
    private fun findLanguageSyntax(language : Language): LanguageSyntax {

        val result = languagesInDatabase.find {it.name == language}
        if (result != null){
            return result
        }else{
            return LanguageSyntax(-1, Language.NONE, Script.UNIQUE,byteArrayOf(0,0))
        }

    }


    private fun getLanguageUnicode(language : Language): ByteArray {
        val item : LanguageSyntax = findLanguageSyntax(language)
        return item.unicodeRange
    }

    fun compareTextToLanguage(text : Text, language : Language): Boolean{
        val codeRange = getLanguageUnicode(language)
        return text.checkIfInUnicodeRange(codeRange)
    }
}