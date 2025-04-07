package languify.app.classes.databases;

import languify.Language
import languify.app.classes.Text
import java.io.File


class ResultLog{
    private var counter = 0
    private val log: MutableMap<Int, Result> = mutableMapOf()

    // no need to discount duplicate results as this is a log of ALL identifications
    fun addResult(result: Result){
        log.put(counter,result)
        counter++
    }
    fun displayResultLog(){
        //******* need to do with the logger
    }
    fun printResultLogToConsole(){
        val sortedKeys = log.keys.toList().sorted()
        println("-- RESULT LOG --")
        for (key in sortedKeys){
            val correspondingResult = log.get(key)
            val resultString = correspondingResult!!.getStringSummary()
            println(" [$key]   $resultString")
        }
        println("-- END OF RESULTS--")
    }
    fun exportToTXT(){
        val sortedKeys = log.keys.toList().sorted()
        val file = File("output.txt")
        val lines = mutableListOf<String>()

        lines.add("-- RESULT LOG --")
        for (key in sortedKeys) {
            val correspondingResult = log.get(key)
            val resultString = correspondingResult!!.getStringSummary()
            lines.add(" [$key]   $resultString")
        }
        lines.add("-- END OF RESULTS--")

        file.printWriter().use { out ->
            lines.forEach { out.println(it) }
        }
    }


}
