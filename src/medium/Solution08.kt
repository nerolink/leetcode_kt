package medium

import java.util.*

class Solution08 {
    fun myAtoi(str: String): Int {
        val clrStr = str.trim()
        if (clrStr.isEmpty()) return 0
        var sign = charArrayOf('-', '+').toHashSet()
        var digital = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9').toHashSet()
        var temp = LinkedList<Char>()
        if (!(clrStr[0] in sign || clrStr[0] in digital)) return 0
        temp.add(clrStr[0])
        clrStr.substring(1 until clrStr.length).forEach { c ->
            println(c)
            if (c in digital) temp.add(c) else return@forEach
        }
        var site = Int.MAX_VALUE
        var maxLen = 0
        while (site > 0) {
            maxLen++
            site /= 10
        }
        if (temp.size > maxLen + 1) {
            if (clrStr[0] == '-') return Int.MIN_VALUE
            return Int.MAX_VALUE
        }
        var result = 0L
        temp.forEach { c ->
            if (c in digital) {
                result *= 10
                result += c.toInt() - 48
            }
        }
        if (clrStr[0] == '-') result *= -1
        if (result > Int.MAX_VALUE) return Int.MAX_VALUE
        if (result < Int.MIN_VALUE) return Int.MIN_VALUE
        return result.toInt()
    }
}

fun main(args: Array<String>) {
    println(Solution08().myAtoi("3.14159"))
}