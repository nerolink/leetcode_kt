package medium

import java.lang.StringBuilder
import kotlin.math.min

class Solution05 {
    fun longestPalindrome(s: String): String {
        if (s.isEmpty()||s.length==1) {
            return s
        }

        var sb= StringBuilder()
        sb.append("#")
       s.forEach { c-> sb.append(c + "#") }
        var result = findPalindromic(sb.toString())
        return result.filter { c-> c != '#' }

    }

    private fun findPalindromic(s: String):String {
        var id = 0
        var mx = 0
        var res = 0
        var max=0
        val p = IntArray(s.length)
        p[0]=1
        for (i in 1 until s.length) {
            p[i]=if (i<mx) min(p[2 * id - i], mx - i) else 1
            while (i+p[i]<s.length&&i-p[i]>-1&&s[i + p[i]] == s[i - p[i]]) {
                p[i]++
            }
            if (i + p[i] > mx) {       //说明有可能i+p[i]超出mx
                id = i
                mx=i + p[i]
            }
            if (p[i] > max) {
                max = p[i]
                res=i
            }
        }
        return s.substring(res-max+1,res+max)
    }

}

fun main(args: Array<String>) {
    println(Solution05().longestPalindrome("bb"))
}