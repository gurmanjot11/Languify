package languify.app.classes.experts

import android.util.Log
import languify.Language
import languify.app.classes.Text
import languify.app.classes.databases.LanguageSyntaxDatabase

class ExpertManager
{
    private var uniqueResult: Language = Language.NONE
    private var latinResult: Language = Language.NONE
    private var arabicResult: Language = Language.NONE

    private val uniqueExpert: Expert = UniqueExpert()
    private val latinExpert: Expert = LatinExpert()
    private val arabicExpert: Expert = ArabicExpert()


    suspend fun determineLanguage(text: Text, syntaxDatabase: LanguageSyntaxDatabase) : Language {
        var finalResult : Language = Language.NONE
        askExperts(text, syntaxDatabase)
        if (uniqueResult!= Language.NONE){
            finalResult = uniqueResult
        }else if (latinResult!= Language.NONE){
            finalResult = latinResult
        }else if (arabicResult!= Language.NONE){
            finalResult = arabicResult
        }else{
            finalResult = Language.NONE
        }
        Log.i("DEBUGGING BACKEND", "Result from determineLanguage")
        Log.i("DEBUGGING BACKEND", finalResult.toString())
        Log.i("DEBUGGING BACKEND", uniqueResult.toString())
        Log.i("DEBUGGING BACKEND", latinResult.toString())
        Log.i("DEBUGGING BACKEND", arabicResult.toString())

        resetExpertResults()
        return finalResult
    }

    suspend private fun askExperts(text: Text, syntaxDatabase: LanguageSyntaxDatabase){
        uniqueResult = uniqueExpert.guessLanguage(text, syntaxDatabase)
        latinResult = latinExpert.guessLanguage(text, syntaxDatabase)
        arabicResult = arabicExpert.guessLanguage(text, syntaxDatabase)
//        Log.i("BA")
    }

    private fun resetExpertResults(){
        uniqueResult = Language.NONE
        latinResult = Language.NONE
        arabicResult = Language.NONE
    }

}
