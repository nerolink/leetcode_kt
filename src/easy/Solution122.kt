package easy

class Solution122 {
    fun maxProfit(prices: IntArray): Int {

        val n=prices.size
        if (n == 0) {
            return 0
        }
        val dp=IntArray(n) //表示在这一天卖出最多能赚多少
        for (i in 1 until n) {
            if (prices[i] > prices[i - 1]) {
                dp[i] = dp[i - 1] + prices[i] - prices[i - 1]
            } else {
                dp[i]=dp[i-1]
            }
        }

        return dp[n-1]
    }
}