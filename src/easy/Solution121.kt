package easy

class Solution121 {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        if (n == 0) {
            return 0
        }
        val dMin = IntArray(n)        //d[i] 由[0,i]的最小值
        val dMax = IntArray(n)        //d[i] [i,n-1]的最大值
        var result = 0
        dMin[0] = prices[0]
        for (i in 1 until n) {
            dMin[i] = Math.min(dMin[i - 1], prices[i])
        }
        dMax[n - 1] = prices[n - 1]
        for (i in n - 2 downTo 0) {
            dMax[i] = maxOf(dMax[i + 1], prices[i])
        }
        for (i in 0 until n) {
            result = maxOf(result, dMax[i] - dMin[i])

        }
        return result
    }
}