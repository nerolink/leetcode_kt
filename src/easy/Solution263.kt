package easy

class Solution263 {
    fun isUgly(num: Int): Boolean {
        var n = num
        while (n > 0 && n % 5 == 0) {
            n /= 5
        }
        while (n > 0 && n % 3 == 0) {
            n /= 3
        }
        while (n > 0 && n % 2 == 0) {
            n /= 2
        }
        return n == 1
    }
}

fun main(args: Array<String>) {
    println(Solution263().isUgly(6))
}