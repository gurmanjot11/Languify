package languify.app.classes.databases

import languify.Language
import languify.app.classes.Text
import languify.app.classes.enums.Correctness

class Result(inputStr: Text, latinRes: Language, arabicRes: Language, uniqueRes: Language, overallRes:Language) {
    val inputString=inputStr
    val latinResult = latinRes
    val arabicResult = arabicRes
    val uniqueResult = uniqueRes
    val overallResult = overallRes
    var correctness = Correctness.UNVERIFIED

    fun getInputString():Text{
        return inputString
    }
    fun getLatinResult(): Language{
        return latinResult
    }
    fun getArabicResult(): Language{
        return arabicResult
    }
    fun getUniqueResult(): Language{
        return uniqueResult
    }
    fun getOverallResult(): Language{
        return overallResult
    }
    fun getCorrectness(): Correctness{
        return correctness
    }
    // only offer this function on the final result display page where people can thumbs up or down it
    // thumbs up should send Correctness.CORRECT, down should send Correctness.INCORRECT
    // feel free to modify this method to make it easier to implement with front end
    fun verifyCorrectness(actualCorrectness: Correctness){
        correctness=actualCorrectness
    }
}