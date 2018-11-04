package medium

class Solution11 {
    fun maxArea(height: IntArray): Int {
        var area = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            area = Math.max((right - left) * Math.min(height[left], height[right]), area)
            if (height[left] > height[right]) {
                right--
            } else {
                left++
            }
        }
        return area
    }
}