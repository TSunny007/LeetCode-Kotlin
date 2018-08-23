class MaxProfit {
    fun maxProfit(prices: IntArray): Int {
        var map = prices.toList().groupingBy { it }.eachCount().toMutableMap()
        map[12] = 23
        map[3] = (map[3])!! - 1

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

    fun maxProfit_2(prices: IntArray): Int{
        var total = 0
        for (i in 0 until prices.size - 1) {
            if (prices[i + 1] > prices[i]) total += prices[i + 1] - prices[i]
        }
        return total
    }
}

fun main(args: Array<String>){
    var maxProfit = MaxProfit()
    println(maxProfit.maxProfit_2(intArrayOf(7,1,5,3,6,4)))
    //println(maxProfit.maxProfit_2(intArrayOf(1,2,3,4,5)))
}