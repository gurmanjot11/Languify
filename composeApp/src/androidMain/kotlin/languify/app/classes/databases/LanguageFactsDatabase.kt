package languify.app.classes.databases

import languify.Language

val languageFactsDatabaseItems: List<LanguageFacts> = listOf (
    // LATIN LANGUAGES
//    LanguageFacts(1, "italian", "Ciao","arrivederci", "Come stai", 63000000, listOf("Italy","Canada","Spain"), listOf("Italy","Canada","America") ),

    LanguageFacts(0, "unknown", "???","???", "???", "123456789",
        listOf("Italy","Canada","Spain", "Unite States", "England"), ),

    LanguageFacts(1, "english", "Hello","goodbye", "how are you", "1.5 billion",
        listOf("Canada", "Unite States", "United Kingdom"), ),

    LanguageFacts(2, "spanish", "Hola","adiós", "¿Cómo estás?", "500 million",
        listOf("Spain", "Mexico", "Colombia "), ),

    LanguageFacts(3, "french", "Bonjour","au revoir", "Comment ça va? or Ça va?", "300 million",
        listOf("France", "Belgium", "Canada "), ),

    LanguageFacts(4, "portuguese", "olá","adeus", "Como você está?", "260 million",
        listOf("Portugal", "Brazil", "Angola"), ),

    LanguageFacts(5, "german", "Hallo","Verabschiedung", "Wie geht es dir?", "135 million",
        listOf("Germany", "Austria", "Switzerland"), ),

    LanguageFacts(6, "vietnamese", "Xin chào","tạm biệt\n", "Bạn khỏe không?", "86 million",
        listOf("Vietnam"), ),

    LanguageFacts(7, "turkish", "Merhaba","Güle güle\n", "Nasılsın", "85 million",
        listOf("Turkey", "Cyprus "), ),

    LanguageFacts(8, "polish", "Witam","do widzenia", "Jak się masz?", "45 million",
        listOf("Poland"), ),

    // ARABIC LANGUAGES
    LanguageFacts(9, "arabic", "mrhban (مرحبًا)", "mae alsalama (مع السلامة)", "kayf haluk (كيف حالك؟)", "310 million native (spread over 20+ countries)",
        listOf("Algeria","Bahrain", "Chad"), ),

    LanguageFacts(10, "farsi", "salam (سلام)", "khodahafez (خداحافظ)", "Hālet chetore?  (حالت چطوره؟)", "70 million native, ~110 million total",
        listOf("Iran"), ),

    LanguageFacts(11, "dari", "As-salâmo 'alaykom (ااسال م عليكم)", "Khoda hafez", "Hāl-e shomā chetor ast? (حال شما چطور است؟)", "15–18 million",
        listOf("Afghanistan "), ),

    LanguageFacts(12, "udru", "helo (ہیلو )", "aluda (الوداع)", "Aap kaise hain? (آپ کیسے ہیں؟)", "70 million native, 230 million total",
        listOf("Pakistan", "India "), ),

    LanguageFacts(13, "uyghur", "Essalamu eleykum", "Khayr khosh", "Qandaq ehwaliŋiz? (قانداق ئەھۋالىڭىز؟)", "10–12 million",
        listOf("China (regional official status in Xinjiang Uyghur Autonomous Region)"), ),

    LanguageFacts(14, "kurdish", "Slav", "bi xatirê te", "Kurmanji: Tu çawa yî?, Sorani: Çon î? ", "30–40 million",
        listOf("Iraq (official in Kurdistan Region)", "Syria (de facto in Kurdish-controlled areas)", "Turkey (limited recognition)"), ),

    LanguageFacts(15, "pashto", "salam (سلام)", "paa makha mo kha (په مخه مو ښه)", "Ta tsenga ye? (ته څنګه یې؟)", "40–50 million",
        listOf("Afghanistan (co-official with Dari)", "Pakistan (regional official language in Khyber Pakhtunkhwa)"), ),

    // UNIQUE LANGUAGES
    LanguageFacts(16, "korean", "annyeonghaseyo", "annyeonghi gaseyo (안녕히 가세요)", "어떻게 지내세요? (eotteoke jinaeseyo?)", "82 million",
        listOf("South Korea", "North Korea"), ),

    LanguageFacts(17, "armenian", "barev (բարև)", "ts’tesut’yun (ցտեսություն)", "Ինչպե՞ս ես։ (Inch’pes es?)", "6.7 million",
        listOf("Armenia"), ),

    LanguageFacts(18, "georgian", "gamarjoba (გამარჯობა)", "nakhvamdis (ნახვამდის)", "როგორ ხარ? (Rogor khar?)", "4 million",
        listOf("Georgia"), ),

    LanguageFacts(19, "sinhala", "āyubōvan (ආයුබෝවන්)", "āyubōvan (ආයුබෝවන්)", "ඔබට කොහොමද? (Obata kohomada?)", "17 million native, 3 million L2 (Sri Lanka)",
        listOf("Sri Lanka"), ),

    LanguageFacts(20, "hebrew", "shlum (shlum)", "lehitra'ot (להתראות)", "(מה שלומך) meh shlomch", "9 million",
        listOf("Israel"), ),

    LanguageFacts(21, "inuktitut", "Halu", "Tavvauvutit", "Qanuippit?", "39,000",
        listOf("Canada (official in Nunavut and parts of Northwest Territories)"), ),

    LanguageFacts(22, "cherokee", "Osiyo", "donadagohvi", "ᎯᎠ? (Hi-a?) or ᏙᎯᏧ? (Do hi tsu?) — varies by dialect", "2,000 ",
        listOf("USA (recognized in the Cherokee Nation & some Oklahoma institutions)"), ),

    LanguageFacts(23, "tamil", "Vaṇakkam (வணக்கம்)", "Viṭaipeṟukiṟēṉ (விடைபெறுகிறேன்)", "எப்படி இருக்கிறீர்கள்? (Eppaṭi irukkiṟīrkaḷ?)", "85 million",
        listOf("India (official in Tamil Nadu),", "Sri Lanka", "Singapore"), ),

    LanguageFacts(24, "khmer", "suostei (សួស្តី)", "leahaey (លាហើយ)", "សុខសប្បាយរបស់អ្នកដែរឬទេ? (Sok sabbay robos anak dae rœ te?)", "17 million",
        listOf("Cambodia"), ),

    )

fun retrieveLanguageFact(language: Language): LanguageFacts {

    for (item: LanguageFacts in languageFactsDatabaseItems ) {
        if (language.equals(item.language)) {
            return item
        }
    }
    return languageFactsDatabaseItems.get(0);
}
