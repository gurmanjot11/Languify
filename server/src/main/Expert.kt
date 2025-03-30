package server.src.main

interface Expert {
    fun determineLanguage(filePath: String): String
}