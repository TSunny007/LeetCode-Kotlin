class HouseRobber {
    fun rob(nums: IntArray): Int {
        if (nums.size === 0) return 0
        val memo = IntArray(nums.size + 1)
        memo[0] = 0
        memo[1] = nums[0]
        for (i in 1 until nums.size) {
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + nums[i])
        }
        return memo[nums.size]
    }
}

fun main(args: Array<String>) {
    var houseRobber = HouseRobber()
    println(houseRobber.rob(intArrayOf(
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)))
}
