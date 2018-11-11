package medium

import java.util.*

class Solution131 {
    fun partition(s: String): List<List<String>> {
        val dp = Array(s.length) { BooleanArray(s.length) }
        val result=LinkedList<List<String>>()
        for (i in s.length - 1 downTo 0) {
            for (j in i until s.length) {
                if (j == i || (s[i] == s[j] && i - j == 1)) {
                    dp[i][j] = true
                } else if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1]
                }
            }
        }

        fun find(start: Int, list: MutableList<String>) {
            val nexts = LinkedList<Int>()
            for (i in start until s.length) {
                if (dp[start][i]) {
                }
            }
        }
    }
}