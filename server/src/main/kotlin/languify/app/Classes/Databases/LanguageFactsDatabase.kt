package languify.app.Classes.Databases

import languify.Language
import languify.LanguageFacts

// TODO ADD MORE DATABASE ITEMS!!!!

val languageFactsDatabaseItems: List<LanguageFacts> = listOf (
    // LATIN LANGUAGES
//    LanguageFacts(1, "italian", "Ciao","arrivederci", "Come stai", 63000000, listOf("Italy","Canada","Spain"), listOf("Italy","Canada","America") ),

    LanguageFacts(0, "unknown", "???","???", "???", 1350445300,
        listOf("Italy","Canada","Spain", "Unite States", "England"), listOf("Italy","Canada","United States")),


    LanguageFacts(1, "english", "Hello","goodbye", "how are you", 1350000000,
        listOf("Italy","Canada","Spain", "Unite States", "England"), listOf("Italy","Canada","United States")),

    // ARABIC LANGUAGES
    LanguageFacts(9, "arabic", "mrhban", "mae alsalama", "kayf haluk", 274000000,
        listOf("Algeria","Bahrain", "Chad", "Comoros", "Djibouti", "Egypt", "Eritrea", "Iraq"), listOf("Saudi Arabia","Iraq","Qatar")),


    // UNIQUE LANGUAGES
    LanguageFacts(16, "korean", "annyeonghaseyo", "annyeonghi gaseyo", "eotteohge jinaeseyo", 81000000,
        listOf("South Korea", "North Korea"), listOf("South Korea", "North Korea", "Canada")),
)

fun retrieveLanguageFact(language: String): LanguageFacts {

    for (item:LanguageFacts in languageFactsDatabaseItems ) {
        if (language.equals(item.language)) {
            return item
        }
    }
    return languageFactsDatabaseItems.get(0);
}
