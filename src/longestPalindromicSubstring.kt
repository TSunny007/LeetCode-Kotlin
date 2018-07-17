class LongestPalindromicSubstring {
    var s: String = ""
    fun longestPalindromicSubstring(s: String): String {
        var N = s.length
        val array: Array<BooleanArray> = Array(N, {BooleanArray(N)})
        var start = 0
        var len = 1

        for (k in 1 until N) {
            for (i in 1..N-k) {
                array[i][i+k] = array[i+1][1+k-1] && array[i-1] == array[i+k-1]
                if (array[i][i+k] && k+1 > len) {
                    start = i-1
                    len = k+1
                }
            }
        }

        return s.substring(start, start+len)
    }
}

fun main(args: Array<String>){
    var longestPalindrome = LongestPalindromicSubstring()
    println(longestPalindrome.longestPalindromicSubstring("ababa"))
}