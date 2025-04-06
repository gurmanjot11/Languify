package languify.app.classes.databases

import languify.Language
import languify.Script
import languify.app.classes.Text
import java.lang.Character.UnicodeBlock


data class LanguageSyntax(
    val id: Int,
    val name: Language,
    //unique, latin, arabic
    //maybe remove this idk
    val category: Script,
    val unicodeBlock: UnicodeBlock
    //val unicodeRangeLower: Int
    //val unicodeRangeUpper: Int

)

