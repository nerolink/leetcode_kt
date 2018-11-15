package medium

class Solution279 {
    fun numSquares(n: Int): Int {
        var dp = IntArray(n + 1)
        for (i in 1..n) {
            dp[i] = i       //最多就i个
            var j = 1
            while (j * j <= i) {
                dp[i] = minOf(dp[i], dp[i - j * j] + 1)
                j++
            }
        }
        return dp[n]
    }
}