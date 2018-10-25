package medium

import java.util.*
import kotlin.collections.HashSet

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1) return 1
        var queue = mutableListOf<Char>()
        val set = hashSetOf<Char>()
        var result = 0
        s.forEach { c ->
            if (!set.contains(c)) {
                set.add(c)
                queue.add(c)
            } else {
                if (queue.size > result) result = queue.size
                while (queue[0] != c) set.remove(queue.removeAt(0))
                queue.removeAt(0)
                queue.add(c)
            }
        }
        if (queue.size > result) {
            result = queue.size
        }
        return result
    }

}