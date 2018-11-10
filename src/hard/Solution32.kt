package hard

import java.util.*

class Solution32 {
    fun longestValidParentheses(s: String): Int {
        var dp = IntArray(s.length + 1)

        fun safeIndexDp(index: Int):Int {
            if (index < 0||index>dp.size-1) {
                return 0
            }
            return dp[index]
        }

        fun safeIndexS(index: Int):Char {
            if (index < 0||index>s.length-1) {
                return ' '
            }
            return s[index]
        }


        for (i in 0 until s.length) {
            if (i>0&&s[i] == ')' && safeIndexS(i - dp[i - 1] - 1) == '(') {
//                dp[i] = dp[i - dp[i - 1] - 2] + 2 + dp[i - 1]
                dp[i]=safeIndexDp(i-safeIndexDp(i-1)-2)+2+safeIndexDp(i-1)
            }
        }
        var max = 0
        for (i in 0 until dp.size) {
            max=Math.max(max,dp[i])
        }
        return max
    }
}