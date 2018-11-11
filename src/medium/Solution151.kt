package medium

class Solution151 {
    /**
     * 使用的是一数组存最大的，一个数组存最小的（为了防止负负得正的情况[2,-3,-4]）
     */
    fun maxProduct(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        val dp = IntArray(nums.size)
        val dn = IntArray(nums.size)
        var result = nums[0]
        dp[0] = nums[0]
        dn[0] = nums[0]
        for (i in 1 until nums.size) {

            dp[i] = maxOf(nums[i], dp[i - 1] * nums[i], dn[i - 1] * nums[i])
            dn[i] = minOf(nums[i], dp[i - 1] * nums[i], dn[i - 1] * nums[i])
            result = Math.max(result, dp[i])
        }
        return result
    }

//    fun maxProduct(nums: IntArray): Int {
//        val dp = IntArray(nums.size)
//        val dn = IntArray(nums.size)
//
//    }

}