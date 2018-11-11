package hard

class Solution115 {
    fun numDistinct(s: String, t: String): Int {
        val dp = Array(s.length + 1) { IntArray(t.length + 1) }
        for (i in 0..s.length) {
            dp[i][0] = 1
        }
        for (j in 1..t.length) {
            for (i in j..s.length) {
                if (s[i] == t[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
                } else {
                    dp[i][j] = dp[i - 1][j]
                }
            }
        }
        return dp[s.length][t.length]
    }
}