package languify.app.classes.experts

import languify.Language
import languify.app.classes.Text
import languify.app.classes.databases.LanguageSyntaxDatabase

class UniqueExpert : Expert {

    override fun guessLanguage(text: Text, syntaxDatabase : LanguageSyntaxDatabase): Language {


        var guess : Language = Language.NONE

        if (syntaxDatabase.compareTextToLanguage(text, Language.KOREAN)){
            guess = Language.KOREAN
        }else if (syntaxDatabase.compareTextToLanguage(text, Language.ARMENIAN)){
            guess = Language.ARMENIAN
        }else if (syntaxDatabase.compareTextToLanguage(text, Language.GEORGIAN)){
            guess = Language.GEORGIAN
        }else if (syntaxDatabase.compareTextToLanguage(text, Language.SINHALA)){
            guess = Language.SINHALA
        }else if (syntaxDatabase.compareTextToLanguage(text, Language.HEBREW)){
            guess = Language.HEBREW
        }else if (syntaxDatabase.compareTextToLanguage(text, Language.INUKTITUT)){
            guess = Language.INUKTITUT
        }else if (syntaxDatabase.compareTextToLanguage(text, Language.CHEROKEE)){
            guess = Language.CHEROKEE
        }else if (syntaxDatabase.compareTextToLanguage(text, Language.TAMIL)){
            guess = Language.TAMIL
        }else if (syntaxDatabase.compareTextToLanguage(text, Language.KHMER)){
            guess = Language.KHMER
        }else{
            guess = Language.NONE
        }

        return guess
    }




}