object Bob {
    fun hey(input: String): String {
        val trimmedInput = input.trim()

        return when {
            trimmedInput.isBlank() -> "Fine. Be that way!"
            trimmedInput.endsWith("?") && !trimmedInput.isCaps() -> "Sure."
            trimmedInput.endsWith("?") && trimmedInput.isCaps() -> "Calm down, I know what I'm doing!"
            input.isCaps() -> "Whoa, chill out!"
            else -> "Whatever."
        }
    }

    private fun String.isCaps(): Boolean {
        return any { it.isLetter() } && uppercase() == this
    }
}
