class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class TwoSum {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return rec( l1, l2)
    }

    fun rec(l1: ListNode?, l2: ListNode?, carry: Int=0): ListNode? {
        if (l1 == null && l2 == null && carry == 0) {
            return null
        }
        var sum = (l1?.`val` ?: 0) + (l2?.`val` ?:0) + carry

        var l3 = ListNode(sum%10)
        l3.next = rec(l1?.next, l2?.next, sum/10)
        return l3
    }
}

fun main(args: Array<String>){
    var sol = TwoSum()
    var a = ListNode(`val` = 5)
    a.next = ListNode(`val` = 6)
    (a.next)?.next = ListNode(`val` = 4)


    var b = ListNode(`val` = 2)
    b.next = ListNode(`val` = 4)
    (b.next)?.next = ListNode(`val` = 3)

    var c = sol.addTwoNumbers(b,a)
    println("${c?.`val`} ${c?.next?.`val`} ${c?.next?.next?.`val`}")
}


