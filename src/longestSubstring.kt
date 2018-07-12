class LongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length <= 1) return s.length

        var seq:HashSet<Char> =  HashSet();
        var longestLength = 0;
        var i = 0
        var j = i
        while (s.length - i > longestLength ) {
            while (j < s.length && !seq.contains(s[j])) {
                seq.add(s[j++])
            }
            longestLength = if (seq.size < longestLength) longestLength else seq.size
            seq.clear()
            i++
            j = i
        }
        return longestLength;
    }
}

fun main(args: Array<String>){
    var longestSubstring = LongestSubstring()
    println(longestSubstring.lengthOfLongestSubstring(""))
}