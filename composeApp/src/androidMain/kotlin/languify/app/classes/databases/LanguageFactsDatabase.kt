package languify.app.classes.databases

import languify.Language

class LanguageFactsDatabase {
    private val languagesInDatabase = mutableListOf<LanguageFacts>()

    init{
        addLanguage(0, Language.NONE,"unknown", "none","none", "none", "none",
            listOf())

        addLanguage(1, Language.ENGLISH,"English", "Hello","Goodbye", "How are you?", "1.5 billion",
            listOf("Canada", "United States", "United Kingdom"))

        addLanguage(2, Language.SPANISH,"Spanish", "Hola","Adiós", "¿Cómo estás?", "500 million",
            listOf("Spain", "Mexico", "Colombia "))

        addLanguage(3, Language.FRENCH,"French", "Bonjour","Au revoir", "Comment ça va?", "300 million",
            listOf("France", "Belgium", "Canada "))

        addLanguage(4, Language.PORTUGUESE,"Portuguese", "Olá","Adeus", "Como você está?", "260 million",
            listOf("Portugal", "Brazil", "Angola"))

        addLanguage(5, Language.GERMAN,"German", "Hallo","Verabschiedung", "Wie geht es dir?", "135 million",
            listOf("Germany", "Austria", "Switzerland"))

        addLanguage(6, Language.VIETNAMESE,"Vietnamese", "Xin chào","Tạm biệt", "Bạn khỏe không?", "86 million",
            listOf("Vietnam"))

        addLanguage(7, Language.TURKISH,"Turkish", "Merhaba","Güle güle", "Nasılsın", "85 million",
            listOf("Turkey", "Cyprus "))

        addLanguage(8, Language.POLISH,"Polish", "Witam","Do widzenia", "Jak się masz?", "45 million",
            listOf("Poland"))

        // ARABIC LANGUAGES
        addLanguage(9, Language.ARABIC,"Arabic", "Mrhban (مرحبًا)", "Mae alsalama (مع السلامة)", "Kayf haluk (كيف حالك؟)", "491 million",
            listOf("Algeria","Bahrain", "Chad"))

        addLanguage(10, Language.PERSIAN,"Persian", "Salam (سلام)", "Khodahafez (خداحافظ)", "Hālet chetore?  (حالت چطوره؟)", "110 million",
            listOf("Iran"))

        addLanguage(12, Language.URDU,"Urdu", "Helo (ہیلو )", "Aluda (الوداع)", "Aap kaise hain? (آپ کیسے ہیں؟)", "230 million total",
            listOf("Pakistan", "India "))

        addLanguage(14, Language.KURDISH,"Kurdish", "Slav", "Bi xatirê te", "Kurmanji: Tu çawa yî?, Sorani: Çon î? ", "30–40 million",
            listOf("Iraq (official in Kurdistan Region)", "Syria (de facto in Kurdish-controlled areas)", "Turkey (limited recognition)"))

        addLanguage(15, Language.PASHTO,"Pashto", "Salam (سلام)", "Paa makha mo kha (په مخه مو ښه)", "Ta tsenga ye? (ته څنګه یې؟)", "40–50 million",
            listOf("Afghanistan (co-official with Dari)", "Pakistan (regional official language in Khyber Pakhtunkhwa)"))

        // UNIQUE LANGUAGES
        addLanguage(16, Language.KOREAN,"Korean", "Annyeonghaseyo", "Annyeonghi gaseyo (안녕히 가세요)", "eotteoke jinaeseyo? (어떻게 지내세요?)", "82 million",
            listOf("South Korea", "North Korea"))

        addLanguage(17, Language.ARMENIAN,"Armenian", "Barev (բարև)", "Ts’tesut’yun (ցտեսություն)", "Ինչպե՞ս ես։ (Inch’pes es?)", "6.7 million",
            listOf("Armenia"))

        addLanguage(18, Language.GEORGIAN,"Georgian", "Gamarjoba (გამარჯობა)", "Nakhvamdis (ნახვამდის)", "Rogor khar? (როგორ ხარ?)", "4 million",
            listOf("Georgia"))

        addLanguage(19, Language.SINHALA,"Sinhala", "āyubōvan (ආයුබෝවන්)", "āyubōvan (ආයුබෝවන්)", "Obata kohomada? (ඔබට කොහොමද?)", "20 million",
            listOf("Sri Lanka"))

        addLanguage(20, Language.HEBREW,"Hebrew", "Shalom", "Lehitra'ot (להתראות)", "(מה שלומך) Meh shlomech", "9 million",
            listOf("Israel"))

        addLanguage(21, Language.INUKTITUT,"Inuktitut", "Halu", "Tavvauvutit", "Qanuippit?", "39,000",
            listOf("Canada (official in Nunavut and parts of Northwest Territories)"))

        addLanguage(22, Language.CHEROKEE,"Cherokee", "Osiyo", "Conadagohvi", "ᎯᎠ? (Hi-a?) or ᏙᎯᏧ? (Do hi tsu?) — varies by dialect", "2,000 ",
            listOf("USA (recognized in the Cherokee Nation & some Oklahoma institutions)"))

        addLanguage(23, Language.TAMIL,"Tamil", "Vaṇakkam (வணக்கம்)", "Viṭaipeṟukiṟēṉ (விடைபெறுகிறேன்)", "எப்படி இருக்கிறீர்கள்? (Eppaṭi irukkiṟīrkaḷ?)", "85 million",
            listOf("India (official in Tamil Nadu),", "Sri Lanka", "Singapore"))

        addLanguage(24, Language.KHMER,"Khmer", "suostei (សួស្តី)", "leahaey (លាហើយ)", "សុខសប្បាយរបស់អ្នកដែរឬទេ? (Sok sabbay robos anak dae rœ te?)", "17 million",
            listOf("Cambodia"))

    }

    private fun addLanguage(newId: Int, newLanguage: Language, newLanguageName: String, newHello: String, newGoodbye: String, newHowAreYou: String, newNumberOfSpeakers: String, newOfficialLanguageCountries: List<String>):LanguageFacts{
        val nextLanguage = LanguageFacts(newId,newLanguage,newLanguageName,newHello,newGoodbye,newHowAreYou,newNumberOfSpeakers, newOfficialLanguageCountries)
        languagesInDatabase.add(nextLanguage)
        return nextLanguage
    }

    fun getLanguageFacts(language : Language) : LanguageFacts {
        val result = languagesInDatabase.find { it.language == language }
        if (result != null){
            return result
        }else{
            return LanguageFacts(0, Language.NONE,"unknown", "none","none", "none", "none",
                listOf())
        }

    }

}