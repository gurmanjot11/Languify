package languify

import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson {
            }
    }
    routing {
        get("/json/gson") {
                call.respond(mapOf("hello" to "world"))
            }
        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
        get("/json/secret") {
            call.respond(mapOf(
                "hello" to "world",
                "Andy" to "the Great one",
                "Cheukman" to "the Man",
                "Gurmanjot" to "the Genuius",
                "Sarah" to "the Complete One",
                "Ke Ma" to "the Prestige"
            ))
        }
    }
}
