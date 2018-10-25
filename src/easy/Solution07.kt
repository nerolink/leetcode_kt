package easy

import java.lang.NumberFormatException
import java.lang.StringBuilder
import kotlin.math.absoluteValue
import kotlin.math.sign

class Solution07 {
    fun reverse(x: Int): Int {
        if (x == Int.MIN_VALUE) {
            return 0
        }
        val sb=StringBuilder()
        val str=x.absoluteValue.toString()
        for (i in str.length - 1 downTo 0) {
            sb.append(str[i])
        }
        try {
            return x.sign * sb.toString().toInt()
        } catch (e: NumberFormatException) {
            return 0
        }
    }
}

fun main(args: Array<String>) {
    println(Solution07().reverse(1534236469))
}