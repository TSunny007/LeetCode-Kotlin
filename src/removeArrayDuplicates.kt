class RemoveArrayDuplicates {
    fun removeDuplicates(a: IntArray): Int {
        if (a.size <= 1) return a.size
        var index = 1
        var i = 0
        var j = i+1

        while(i < (a.size-1)) {
            var num = a[i]
            while (a[j] <= num) {
                if (j == a.size-1) return index
                j++
            }
            a[index++] = a[j]
            i++
        }
        return index
    }
}

fun main(args: Array<String>) {
    var noDuplicates = RemoveArrayDuplicates()
    println(noDuplicates.removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4)))
}