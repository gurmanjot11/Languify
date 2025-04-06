package languify.app.classes.experts

import android.util.Log
import languify.Language
import languify.app.classes.Text
import languify.app.classes.databases.LanguageSyntaxDatabase
import languify.app.classes.databases.Result
import languify.app.classes.databases.ResultLog

class ExpertManager(log: ResultLog)
{
    private var uniqueResult: Language = Language.NONE
    private var latinResult: Language = Language.NONE
    private var arabicResult: Language = Language.NONE

    private val uniqueExpert: Expert = UniqueExpert()
    private val latinExpert: Expert = LatinExpert()
    private val arabicExpert: Expert = ArabicExpert()

    private val resultLog: ResultLog = log



    fun determineLanguage(text: Text, syntaxDatabase: LanguageSyntaxDatabase) : Result {
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

        //store the result
        val result = Result(text, latinResult, arabicResult, uniqueResult, finalResult)
        resultLog.addResult(result)
        // *******need to print the logged result to the logger
        
        resetExpertResults()
        return result
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
