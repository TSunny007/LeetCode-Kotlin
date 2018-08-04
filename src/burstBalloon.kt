class BurstBalloon {
    fun maxCoins(prices: IntArray): Int {
        var prices = prices.filter({ balloon -> balloon > 0}) as ArrayList
        prices.add(0,1)
        prices.add(1)
        var priceFiltered = prices.toList().toIntArray()

        var dp = Array(priceFiltered.size){IntArray(priceFiltered.size)}
        return t(priceFiltered, 0, priceFiltered.size - 1, dp)
    }

    fun t(balloons: IntArray, left: Int, right: Int, dp: Array<IntArray>): Int {
        if (left + 1 == right) return 0
        if (dp[left][right] > 0) return dp[left][right]

        var ans = 0
        for (l in left + 1 until right) {
            ans = maxOf(ans, balloons[left]*balloons[l]*balloons[right] + t(balloons, left, l, dp) + t(balloons, l, right, dp))
        }

        dp[left][right] = ans
        return ans
    }
}

fun main(args: Array<String>){
    var maxProfit = BurstBalloon()
    println(maxProfit.maxCoins(intArrayOf(3,1,5,8)))
}