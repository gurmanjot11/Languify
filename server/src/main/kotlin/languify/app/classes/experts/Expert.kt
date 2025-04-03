package languify

interface Expert {
    fun guessLanguage(text: Text): Language
}
