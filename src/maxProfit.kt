class MaxProfit {
    fun maxProfit(prices: IntArray): Int {
        val len = prices.size
        if (len == 0) {
            return 0
        }
        var buy = prices[0]
        var res = 0
        for (i in 1 until len) {
            if (prices[i] < buy) {
                buy = prices[i]
            } else if (prices[i] > buy) {
                res = if (res < prices[i] - buy) prices[i] - buy else res
            }
        }
        return res
    }
}

fun main(args: Array<String>){
    var maxProfit = MaxProfit()
    println(maxProfit.maxProfit(IntArray(10)))
}