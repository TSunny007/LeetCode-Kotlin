class RemoveBoxes {

    fun removeBoxes(boxes: IntArray): Int {
        val n = boxes.size
        val dp = Array(n) { Array(n) { IntArray(n) } }
        return t(boxes, 0, n - 1, 0, dp)
    }

    private fun t(boxes:IntArray , i: Int, j: Int, k: Int, dp: Array<Array<IntArray>>): Int {
        var i = i
        var k = k
        if (i > j) return 0
        if (dp[i][j][k] > 0) return dp[i][j][k]

        while (i + 1 <= j && boxes[i + 1] == boxes[i]) {
            i++
            k++
        }

        var res = (k + 1) * (k + 1) + t(boxes,  i + 1,j,0, dp)

        for (m in i + 1..j) {
            if (boxes[i] == boxes[m]) {
                res = Math.max(res, t(boxes, i + 1, m - 1, 0, dp) + t(boxes, m, j, k + 1, dp))
            }
        }
        dp[i][j][k] = res
        return res
    }

}

fun main(args: Array<String>){
    val x: IntArray = intArrayOf(1, 3, 2, 2, 2, 3, 4, 3, 1)
    print(RemoveBoxes().removeBoxes(x))
}
