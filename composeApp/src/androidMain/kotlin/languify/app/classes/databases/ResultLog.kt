package languify.app.classes.databases;

import languify.Language
import languify.app.classes.Text

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


}
