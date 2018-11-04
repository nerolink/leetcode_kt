package medium

import java.lang.StringBuilder


class Solution12 {
    fun intToRoman(num: Int): String {
        var n = num
        val d = listOf(Pair(1000, "M"), Pair(900, "CM"), Pair(500, "D"), Pair(400, "CD"), Pair(100, "C"), Pair(90, "XC"), Pair(50, "L"), Pair(40, "XL"), Pair(10, "X"), Pair(9, "IX"), Pair(5, "V"), Pair(4, "IV"), Pair(1, "I"))
        val result = StringBuilder()
        for (p in d) {
            while (n >= p.first) {
                result.append(p.second)
                n -= p.first
            }
        }
        return result.toString()
    }
}