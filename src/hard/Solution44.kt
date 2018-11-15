package hard

class Solution44 {
    fun isMatch(s: String, p: String): Boolean {
        val dp = Array(s.length + 1) { BooleanArray(p.length + 1) } //坐标分别是s和p子串的长度
        dp[0][0] = true
        for (i in 0 until p.length) {           //以连续 '*' 开头的能和s的空串匹配
            if (p[i] != '*') {
                break
            }
            dp[0][i+1]=true
        }


        for (i in 1..s.length) {
            for (j in 1..p.length) {
                if (s[i-1] == p[j-1] || p[j-1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1]
                } else if (p[j-1] == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j]
                }
            }
        }
        return dp[s.length][p.length]
    }
}

fun main(args: Array<String>) {
    Solution44().isMatch("abced","*a*b")
}