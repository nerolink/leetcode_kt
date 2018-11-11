package hard

import java.lang.StringBuilder
import java.util.*

class Solution97 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s3.length != s1.length + s2.length) {
            return false
        }

        val dp = Array(s1.length + 1) { BooleanArray(s2.length + 1) }
        dp[0][0] = true
        for (i in 1..s1.length) {
            dp[i][0] = dp[i - 1][0] && (s1[i - 1] == s3[i - 1])
        }
        for (j in 1..s2.length) {
            dp[0][j] = dp[0][j - 1] && (s2[j - 1] == s3[j - 1])
        }


        for (i in 1..s1.length) {
            for (j in 1..s2.length) {
                dp[i][j] = (dp[i - 1][j] && (s1[i - 1] == s3[i + j - 1])) || (dp[i][j - 1] && (s2[j - 1] == s3[i + j - 1]))
            }
        }
        return dp[s1.length][s2.length]
    }
}

fun main(args: Array<String>) {

}