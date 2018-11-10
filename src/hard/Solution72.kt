package hard

class Solution72 {
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word2.length + 1) { IntArray(word1.length + 1) }
        for (i in 1 until dp[0].size) {
            dp[0][i] = i
        }
        for (i in 1 until dp.size) {
            dp[i][0] = i
        }
        for (i in 1 until dp.size) {
            for (j in 1 until dp[i].size) {
                if (word2[i - 1] == word1[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1
                }
            }
        }
        return dp[word2.length][word1.length]
    }
}