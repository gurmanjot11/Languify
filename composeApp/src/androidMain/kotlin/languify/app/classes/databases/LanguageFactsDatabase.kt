package languify.app.classes.databases

import languify.Language

val languageFactsDatabaseItems: List<LanguageFacts> = listOf (

    LanguageFacts(0, Language.NONE,"unknown", "none","none", "none", "none",
        listOf()),

    LanguageFacts(1, Language.ENGLISH,"English", "Hello","Goodbye", "How are you?", "1.5 billion",
        listOf("Canada", "United States", "United Kingdom")),

    LanguageFacts(2, Language.SPANISH,"Spanish", "Hola","Adiós", "¿Cómo estás?", "500 million",
        listOf("Spain", "Mexico", "Colombia ")),

    LanguageFacts(3, Language.FRENCH,"French", "Bonjour","Au revoir", "Comment ça va?", "300 million",
        listOf("France", "Belgium", "Canada ")),

    LanguageFacts(4, Language.PORTUGUESE,"Portuguese", "Olá","Adeus", "Como você está?", "260 million",
        listOf("Portugal", "Brazil", "Angola")),

    LanguageFacts(5, Language.GERMAN,"German", "Hallo","Verabschiedung", "Wie geht es dir?", "135 million",
        listOf("Germany", "Austria", "Switzerland")),

    LanguageFacts(6, Language.VIETNAMESE,"Vietnamese", "Xin chào","Tạm biệt", "Bạn khỏe không?", "86 million",
        listOf("Vietnam")),

    LanguageFacts(7, Language.TURKISH,"Turkish", "Merhaba","Güle güle", "Nasılsın", "85 million",
        listOf("Turkey", "Cyprus ")),

    LanguageFacts(8, Language.POLISH,"Polish", "Witam","Do widzenia", "Jak się masz?", "45 million",
        listOf("Poland")),

    // ARABIC LANGUAGES
    LanguageFacts(9, Language.ARABIC,"Arabic", "Mrhban (مرحبًا)", "Mae alsalama (مع السلامة)", "Kayf haluk (كيف حالك؟)", "491 million",
        listOf("Algeria","Bahrain", "Chad")),

    LanguageFacts(10, Language.PERSIAN,"Persian", "Salam (سلام)", "Khodahafez (خداحافظ)", "Hālet chetore?  (حالت چطوره؟)", "110 million",
        listOf("Iran"), ),

    //LanguageFacts(11, "dari", "As-salâmo 'alaykom (ااسال م عليكم)", "Khoda hafez", "Hāl-e shomā chetor ast? (حال شما چطور است؟)", "15–18 million",
    //    listOf("Afghanistan ")),

    LanguageFacts(12, Language.URDU,"Urdu", "Helo (ہیلو )", "Aluda (الوداع)", "Aap kaise hain? (آپ کیسے ہیں؟)", "230 million total",
        listOf("Pakistan", "India ")),

    LanguageFacts(13, Language.UYGHUR,"Uyghur", "Essalamu eleykum", "Khayr khosh", "Qandaq ehwaliŋiz? (قانداق ئەھۋالىڭىز؟)", "10–12 million",
        listOf("China (regional official status in Xinjiang Uyghur Autonomous Region)")),

    LanguageFacts(14, Language.KURDISH,"Kurdish", "Slav", "Bi xatirê te", "Kurmanji: Tu çawa yî?, Sorani: Çon î? ", "30–40 million",
        listOf("Iraq (official in Kurdistan Region)", "Syria (de facto in Kurdish-controlled areas)", "Turkey (limited recognition)")),

    LanguageFacts(15, Language.PASHTO,"Pashto", "Salam (سلام)", "Paa makha mo kha (په مخه مو ښه)", "Ta tsenga ye? (ته څنګه یې؟)", "40–50 million",
        listOf("Afghanistan (co-official with Dari)", "Pakistan (regional official language in Khyber Pakhtunkhwa)")),

    // UNIQUE LANGUAGES
    LanguageFacts(16, Language.KOREAN,"Korean", "Annyeonghaseyo", "Annyeonghi gaseyo (안녕히 가세요)", "eotteoke jinaeseyo? (어떻게 지내세요?)", "82 million",
        listOf("South Korea", "North Korea")),

    LanguageFacts(17, Language.ARMENIAN,"Armenian", "Barev (բարև)", "Ts’tesut’yun (ցտեսություն)", "Ինչպե՞ս ես։ (Inch’pes es?)", "6.7 million",
        listOf("Armenia")),

    LanguageFacts(18, Language.GEORGIAN,"Georgian", "Gamarjoba (გამარჯობა)", "Nakhvamdis (ნახვამდის)", "Rogor khar? (როგორ ხარ?)", "4 million",
        listOf("Georgia")),

    LanguageFacts(19, Language.SINHALA,"Sinhala", "āyubōvan (ආයුබෝවන්)", "āyubōvan (ආයුබෝවන්)", "Obata kohomada? (ඔබට කොහොමද?)", "20 million",
        listOf("Sri Lanka")),

    LanguageFacts(20, Language.HEBREW,"Hebrew", "Shalom", "Lehitra'ot (להתראות)", "(מה שלומך) Meh shlomech", "9 million",
        listOf("Israel")),

    LanguageFacts(21, Language.INUKTITUT,"Inuktitut", "Halu", "Tavvauvutit", "Qanuippit?", "39,000",
        listOf("Canada (official in Nunavut and parts of Northwest Territories)")),

    LanguageFacts(22, Language.CHEROKEE,"Cherokee", "Osiyo", "Conadagohvi", "ᎯᎠ? (Hi-a?) or ᏙᎯᏧ? (Do hi tsu?) — varies by dialect", "2,000 ",
        listOf("USA (recognized in the Cherokee Nation & some Oklahoma institutions)")),

    LanguageFacts(23, Language.TAMIL,"Tamil", "Vaṇakkam (வணக்கம்)", "Viṭaipeṟukiṟēṉ (விடைபெறுகிறேன்)", "எப்படி இருக்கிறீர்கள்? (Eppaṭi irukkiṟīrkaḷ?)", "85 million",
        listOf("India (official in Tamil Nadu),", "Sri Lanka", "Singapore")),

    LanguageFacts(24, Language.KHMER,"Khmer", "suostei (សួស្តី)", "leahaey (លាហើយ)", "សុខសប្បាយរបស់អ្នកដែរឬទេ? (Sok sabbay robos anak dae rœ te?)", "17 million",
        listOf("Cambodia")),

    )

fun retrieveLanguageFact(language: Language): LanguageFacts {

    for (item: LanguageFacts in languageFactsDatabaseItems ) {
        if (language.equals(item.language)) {
            return item
        }
    }
    return languageFactsDatabaseItems.get(0);
}
