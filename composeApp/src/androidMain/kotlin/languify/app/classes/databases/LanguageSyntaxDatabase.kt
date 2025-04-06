package languify.app.classes.databases

import languify.Language
import languify.Script
import languify.app.classes.Text
import java.lang.Character.UnicodeBlock

class LanguageSyntaxDatabase {
    private var languagesInDatabase = mutableListOf<LanguageSyntax>()
    private var nextID = 1

    init {
        addLanguage(Language.KOREAN, Script.UNIQUE, UnicodeBlock.HANGUL_JAMO)
        addLanguage(Language.ARMENIAN, Script.UNIQUE, UnicodeBlock.ARMENIAN)
        addLanguage(Language.GEORGIAN, Script.UNIQUE, UnicodeBlock.GEORGIAN)
        addLanguage(Language.SINHALA, Script.UNIQUE, UnicodeBlock.SINHALA)
        addLanguage(Language.HEBREW, Script.UNIQUE, UnicodeBlock.HEBREW)
        addLanguage(Language.INUKTITUT, Script.UNIQUE, UnicodeBlock.UNIFIED_CANADIAN_ABORIGINAL_SYLLABICS_EXTENDED)
        addLanguage(Language.CHEROKEE, Script.UNIQUE, UnicodeBlock.CHEROKEE)
        addLanguage(Language.TAMIL, Script.UNIQUE, UnicodeBlock.TAMIL)
        addLanguage(Language.KHMER, Script.UNIQUE, UnicodeBlock.KHMER)
    }

    //figure out how to make some of this stuff mutable
    private fun addLanguage(newName: Language, newCategory: Script, newUnicodeBlock: UnicodeBlock): LanguageSyntax
    {
        val newLanguage = LanguageSyntax(
            id = nextID++,
            name = newName,
            category = newCategory,
            unicodeBlock = newUnicodeBlock
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
            return LanguageSyntax(-1, Language.NONE, Script.UNIQUE,UnicodeBlock.MALAYALAM)
        }

    }


    private fun getLanguageUnicode(language : Language): UnicodeBlock {
        val item : LanguageSyntax = findLanguageSyntax(language)
        return item.unicodeBlock
    }

    fun compareTextToLanguage(text : Text, language : Language): Boolean{
        val codeRange = getLanguageUnicode(language)
        val str = text.getString()
        return str.any {UnicodeBlock.of(it) == codeRange}
    }
}