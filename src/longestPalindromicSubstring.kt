class LongestPalindromicSubstring {
    fun longestPalindromicSubstring(s: String): String {
        var N = s.length
        if (N == 1) return s
        val array: Array<BooleanArray> = Array(N + 1, { index -> BooleanArray(N + 1, { index2 -> true }) })
        var start = 0
        var maxDist = 0

        for (dist in 1 until N) {
            var i = 0
            while (i + dist < N) {
                array[i][i + dist] = array[i + 1][i + dist - 1] && s.substring(i, i + 1) == s.substring(i + dist, i + dist + 1)
                if (array[i][i + dist] && dist > maxDist) {
                    start = i
                    maxDist = dist
                }
                i++
            }
        }
        return s.substring(start, start + maxDist+1)
    }
}

fun main(args: Array<String>) {
    var longestPalindrome = LongestPalindromicSubstring()
    println(longestPalindrome.longestPalindromicSubstring("cbbd"))
}