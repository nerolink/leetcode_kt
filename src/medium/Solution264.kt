package medium

class Solution264 {
    fun nthUglyNumber(n: Int): Int {

        val ugly = IntArray(n)
        ugly[0] = 1
        var index2 = 0
        var index3 = 0
        var index5 = 0
        var factor2 = 2
        var factor3 = 3
        var factor5 = 5

        for (i in 1 until n) {
            var min = minOf(factor2, factor3, factor5)
            ugly[i] = min
            if (min == factor2) {       //必须这样，防止由factor2==factor3之类的方法，不能用switch
                factor2 = 2 * ugly[++index2]
            }
            if (min == factor3) {
                factor3 = 3 * ugly[++index3]
            }
            if (min == factor5) {
                factor5 = 5 * ugly[++index5]
            }
        }
        return ugly[n - 1]
    }
}

fun main(args: Array<String>) {
    println(Solution264().nthUglyNumber(10))
}