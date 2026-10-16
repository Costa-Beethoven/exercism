object EliudsEggs {

    fun eggCount(number: Int): Int{
        var remaining = number
        var eggs = 0

        while (remaining > 0) {
            if (remaining % 2 == 1) {
                eggs++
            }
            remaining /= 2
        }

        return eggs
    }
}
