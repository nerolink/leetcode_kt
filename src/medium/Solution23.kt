package medium

import java.util.*
class Solution23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val n2t = HashMap<Int, Int>()

        lists.forEach { listNode ->
            var node = listNode
            while (node != null) {
                n2t[node.`val`] = n2t.getOrDefault(node.`val`, 0) + 1
                node = node.next
            }
        }
        val temp: LinkedList<Map.Entry<Int, Int>> = LinkedList()
        n2t.forEach { entry -> temp.add(entry) }
        Collections.sort(temp) { entry1, entry2 -> entry1.key - entry2.key }
        val head = ListNode(0)
        var pointer:ListNode? = head
        temp.forEach { entry ->
            for (i in 0 until entry.value) {
                pointer?.next = ListNode(entry.key)
                pointer = pointer?.next
            }
        }
        return head.next
    }

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }
}