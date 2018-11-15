package medium

import java.util.*
import kotlin.test.currentStackTrace


/**
 * 先用DP表示[i,j]区域的子串是否是回文，dp[i][j] = dp[i + 1][j - 1] if s[i]==s[j]
 * 然后用stack来存储深度遍历的路径
 */
class Solution131 {
    fun partition(s: String): List<List<String>> {
        val dp = Array(s.length) { BooleanArray(s.length) }
        val result = LinkedList<List<String>>()
        for (i in s.length - 1 downTo 0) {
            for (j in i until s.length) {
                if (j == i || (s[i] == s[j] && j-i == 1)) {
                    dp[i][j] = true
                } else if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1]
                }
            }
        }
        /**
         * stack-->[[0,2],[3,3],[4,4]]
         */
        fun find(stack: Stack<Int>) {
            if (stack.peek() == (s.length - 1)) {
                val temp = LinkedList<String>()
                for (i in 0 until stack.size - 1 step 2) {
                    temp.add(s.substring(stack[i], stack[i + 1] + 1))
                }
                result.add(temp)
                return
            }
            val i = stack.peek() + 1
            stack.push(i)
            for (j in i until s.length) {
                if (dp[i][j]) {
                    stack.push(j)
                    find(stack)
                    stack.pop()
                }
            }
            stack.pop()
        }

        val stack=Stack<Int>()
        val i = 0
        stack.push(i)
        for (j in i until s.length) {
            if (dp[i][j]) {
                stack.push(j)
                find(stack)
                stack.pop()
            }
        }
        stack.pop()
        return result
    }
}

fun main(args: Array<String>) {
    println(Solution131().partition("aab"))
}