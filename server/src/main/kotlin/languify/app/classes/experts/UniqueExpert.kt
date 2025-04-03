package languify

class UniqueExpert : Expert {

    override fun guessLanguage(text: Text): Language {
        //LanguageSyntaxDatabase.addLanguage()

        //check every single language
        //fix this

        var guess : Language = Language.NONE

        if (compareTextToLanguage(text, Language.KOREAN)){
            guess = Language.KOREAN
        }else if (compareTextToLanguage(text, Language.ARMENIAN)){
            guess = Language.ARMENIAN
        }else if (compareTextToLanguage(text, Language.GEORGIAN)){
            guess = Language.GEORGIAN
        }else if (compareTextToLanguage(text, Language.SINHALA)){
            guess = Language.SINHALA
        }else if (compareTextToLanguage(text, Language.HEBREW)){
            guess = Language.HEBREW
        }else if (compareTextToLanguage(text, Language.INUKTITUT)){
            guess = Language.INUKTITUT
        }else if (compareTextToLanguage(text, Language.CHEROKEE)){
            guess = Language.CHEROKEE
        }else if (compareTextToLanguage(text, Language.TAMIL)){
            guess = Language.TAMIL
        }else if (compareTextToLanguage(text, Language.KHMER)){
            guess = Language.KHMER
        }else{
            guess = Language.NONE
        }

        return guess
    }




}