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
