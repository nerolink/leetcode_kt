package hard

import java.util.*

class Solution25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var aHead = ListNode(0)
        aHead.next = head
        var pointer:ListNode? = aHead
        while (pointer != null) {
            pointer.next = reverse(pointer.next, k)
            pointer=forward(pointer,k)
        }
        return aHead.next
    }

    fun forward(node: ListNode?, k: Int):ListNode? {
        var counter = 0
        var n = node
        while (n != null && counter < k) {
            n = n?.next
            counter++
        }
        return n
    }

    fun reverse(node: ListNode?, k: Int): ListNode? {
        if (node?.next == null) {
            return node
        }
        var n = node
        var counter = 0
        val stack = Stack<ListNode>()
        while (counter < k && n != null) {
            stack.push(n)
            n = n.next
            counter++
        }
        if (counter < k) {
            return node
        }
        var tail = stack.peek().next
        var result = stack.peek()
        while (!stack.isEmpty()) {
            n = stack.pop()
            if (!stack.isEmpty()) {
                n.next = stack.peek()
            }
        }
        n?.next = tail
        return result
    }

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }
}

fun main(args: Array<String>) {
    var aHead=Solution25.ListNode(0)
    var pre:Solution25.ListNode?=aHead
    for (i in 1 until 6){
        pre?.next = Solution25.ListNode(i)
        pre=pre?.next
    }
    println(Solution25().reverseKGroup(aHead.next,2))
}