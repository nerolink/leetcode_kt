package medium

class Solution24 {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        var aHead=ListNode(0)
        aHead.next=head
        var pre: ListNode=aHead
        var pointer = head
        fun switch(node: ListNode): ListNode? {
            if (node.next == null) {
                return node
            }
            var temp = node.next
            node.next = temp?.next
            temp?.next = node
            return temp
        }

        while (pointer != null) {
                var temp = switch(pointer)
                pre.next = temp
                pre = pointer
                pointer = pointer.next
        }
        return aHead.next
    }

    class ListNode(var `val`: Int = 0) {
        var next: ListNode? = null
    }
}