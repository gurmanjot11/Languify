package languify


class LatinExpert: Expert {
    override fun guessLanguage(text: Text): Language {
        return Language.NONE
    }
}
