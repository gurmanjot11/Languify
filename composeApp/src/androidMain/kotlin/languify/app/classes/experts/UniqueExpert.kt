package languify.app.classes.experts

import languify.Language
import languify.app.classes.Text
import languify.app.classes.databases.LanguageSyntaxDatabase

class UniqueExpert : Expert {

    override fun guessLanguage(text: Text): Language {
        //LanguageSyntaxDatabase.addLanguage()

        //check every single language
        //fix this

        var guess : Language = Language.NONE

        if (LanguageSyntaxDatabase.compareTextToLanguage(text, Language.KOREAN)){
            guess = Language.KOREAN
        }else if (LanguageSyntaxDatabase.compareTextToLanguage(text, Language.ARMENIAN)){
            guess = Language.ARMENIAN
        }else if (LanguageSyntaxDatabase.compareTextToLanguage(text, Language.GEORGIAN)){
            guess = Language.GEORGIAN
        }else if (LanguageSyntaxDatabase.compareTextToLanguage(text, Language.SINHALA)){
            guess = Language.SINHALA
        }else if (LanguageSyntaxDatabase.compareTextToLanguage(text, Language.HEBREW)){
            guess = Language.HEBREW
        }else if (LanguageSyntaxDatabase.compareTextToLanguage(text, Language.INUKTITUT)){
            guess = Language.INUKTITUT
        }else if (LanguageSyntaxDatabase.compareTextToLanguage(text, Language.CHEROKEE)){
            guess = Language.CHEROKEE
        }else if (LanguageSyntaxDatabase.compareTextToLanguage(text, Language.TAMIL)){
            guess = Language.TAMIL
        }else if (LanguageSyntaxDatabase.compareTextToLanguage(text, Language.KHMER)){
            guess = Language.KHMER
        }else{
            guess = Language.NONE
        }

        return guess
    }




}