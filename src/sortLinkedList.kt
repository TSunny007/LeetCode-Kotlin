/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 */
class SortedLinkedList {
    var l1: ListNode? = null
    var l2: ListNode? = null

    fun mergeTwoLists(_l1: ListNode?, _l2: ListNode?): ListNode? {
        this.l1 = _l1
        this.l2 = _l2
        if (l1 == null) return l2
        if (l2 == null) return l1
        var newList: ListNode = nextElement()
        var tail = newList
        while (! (l1 == null && l2 == null)) {
            tail.next = nextElement()
            tail = tail.next!!
        }
        return newList
    }

    fun nextElement(): ListNode {
        if (l1 == null) {
            var returnNode = l2!!
            l2 = (l2!!).next
            return returnNode
        }
        if (l2 == null) {
            var returnNode = l1!!
            l1 = (l1!!).next
            return returnNode
        }
        if ((l1!!).`val` > (l2!!).`val`)  {
            var returnNode = l2!!
            l2 = (l2!!).next
            return returnNode
        }
        var returnNode = l1!!
        l1 = (l1!!).next
        return returnNode
    }
}