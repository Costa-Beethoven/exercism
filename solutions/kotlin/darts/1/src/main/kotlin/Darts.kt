object Darts {

    fun score(x: Number, y: Number): Int {
        val xCoord = x.toDouble()
        val yCoord = y.toDouble()

        val distanceSquared = xCoord * xCoord + yCoord * yCoord

        return when {
            distanceSquared <= 1.0 -> 10
            distanceSquared <= 25.0 -> 5
            distanceSquared <= 100.0 -> 1
            else -> 0
        }
    }
}
