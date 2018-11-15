package hard

import medium.Solution

class Solution132 {
    fun minCut(s: String): Int {
        val dp = Array(s.length) { BooleanArray(s.length) }
        val cut = IntArray(s.length )  //用来表示[0,i]的子串最少需要几刀
        for (i in s.length - 1 downTo 0) {
            for (j in i until s.length) {
                if (i == j || (j - i == 1 && s[i] == s[j])) {
                    dp[i][j] = true
                } else if (s[i] == s[j]) {
                    dp[i][j] = dp[i + 1][j - 1]
                }
            }
        }

        for (i in 1 until s.length) {
            var temp = Int.MAX_VALUE
            if (dp[0][i]) {     //如果已经对称的化就不用切了
                continue
            }
            for (j in 1..i) {
                if (dp[j][i]) {
                    temp = Math.min(temp, cut[j - 1] + 1)
                }
            }
            cut[i] = temp
        }
        return cut[cut.lastIndex]
    }
}

fun main(args: Array<String>) {
    println(Solution132().minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"))

}