class ReverseDiagonals {
    fun diagonal(a: List<List<Int>>): List<List<Int>>? {

        val diagonals = ArrayList<ArrayList<Int>>(2*a.size-1)
        val n = a.size
        for (sum in 0 .. (2*(a.size-1))) {
            diagonals.add(ArrayList())
            for (i in maxOf(0, sum - (n - 1)).. minOf((n - 1), sum)) {
                diagonals[sum].add(a[i][sum-i])
            }
        }
        return diagonals
    }
}

fun main(args: Array<String>) {
    var diagonal = ReverseDiagonals()
    println(diagonal.diagonal(listOf(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))))
}
