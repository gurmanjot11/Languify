package languify.app.classes.databases

import languify.Language
import languify.Script
import languify.app.classes.Text

data class LanguageSyntax(
    val id: Int,
    val name: Language,
    //unique, latin, arabic
    val category: Script,
    val unicodeRange: ByteArray
    //val unicodeRangeLower: Int
    //val unicodeRangeUpper: Int
    //maybe more data
) {
    //check what this does and if it works, autogen by intellij
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
//        if (javaClass != other?.javaClass) return false

        other as LanguageSyntax

        if (id != other.id) return false
        if (name != other.name) return false
        if (category != other.category) return false
        if (!unicodeRange.contentEquals(other.unicodeRange)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + category.hashCode()
        result = 31 * result + unicodeRange.contentHashCode()
        return result
    }
}
//navigator for data class
class LanguageSyntaxDatabase() {
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
            return LanguageSyntax(-1,Language.NONE,Script.UNIQUE,byteArrayOf(0,0))
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
