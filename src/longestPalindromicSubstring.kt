class LongestPalindromicSubstring {
    var s: String = ""
    fun longestPalindromicSubstring(s: String): String {
        var N = s.length
        val array: Array<BooleanArray> = Array(N+1 ,{index -> BooleanArray(N+1, {index2 -> true})})
        var start = 0
        var len = 1

        for (i in 1 until N) {
            for (j in 1..N-i) {
                array[j][j+i] = array[j+1][j+i-1] && s.substring(j-1,j) == s.substring(j+i-1,j+i)
                if (array[j][j+i] && i+1 > len) {
                    start = j-1
                    len = i+1
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