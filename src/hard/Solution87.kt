package hard

import java.util.*

class Solution87 {
    fun isScramble(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) {
            return false
        }
        val list1 = s1.toList()
        val list2 = s2.toList()
        Collections.sort(list1)
        Collections.sort(list2)
        if (list1 != list2) {
            return false
        }

        val dp = Array(s1.length) { Array(s2.length) { BooleanArray(s1.length + 1) } }
        for (i in 0 until s1.length) {
            for (j in 0 until s2.length) {
                dp[i][j][1] = s1[i] == s2[j]
            }
        }

        for (len in 2..s1.length) {
            for (i in 0 .. s1.length - len) {
                for (j in 0 .. s2.length - len) {
                    for (split in 1 until len) {
                        dp[i][j][len] = dp[i][j][len]
                                || (dp[i][j][split] && dp[i + split][j + split][len - split])
                                || (dp[i][j + split][len - split] && dp[i + len - split][j][split])
                    }
                }
            }
        }
        return dp[0][0][s1.length]
    }
}