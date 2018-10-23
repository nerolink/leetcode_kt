package medium

import java.util.*
import kotlin.collections.HashSet

class Solution{
    fun lengthOfLongestSubstring(s: String): Int {
        var queue = mutableListOf<Char>()
        val set = hashSetOf<Char>()
        val temp=""
        s.forEach { c->
            if (set.contains(c)) {

            } else {
                set.add(c)
                queue.add(c)
            }
        }
    }

    fun output(queue: MutableList<Char>, set: HashSet<Char>, str: String, c: Char) {
        if (str.length < queue.size) {
            queue.flatMap{}
        }
        while (queue.get(0) != c) {

        }
    }
}