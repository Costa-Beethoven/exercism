object ETL {
    fun transform(source: Map<Int, List<Char>>): Map<Char, Int> {
        val result = mutableMapOf<Char, Int>()
        for ((score, letters) in source) {
            for (letter in letters) {
                result[letter.lowercaseChar()] = score
            }
        }
        return result
    }
}
