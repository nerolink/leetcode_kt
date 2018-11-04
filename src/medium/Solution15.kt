package medium

import java.util.*

class Solution15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val answer = LinkedList<List<Int>>()

        fun increase(l: Int): Int {
            var result = l
            while (result<nums.size&&nums[l] == nums[result]) {
                result++
            }
            return result
        }

        fun decrease(r: Int): Int {
            var result = r
            while (result>=0&&nums[r] == nums[result]) {
                result--
            }
            return result
        }

        var i = 0
        while (i < nums.size) {
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                if (nums[left] + nums[right] + nums[i]==0) {
                    answer.add(listOf(nums[i], nums[left], nums[right]))
                    left = increase(left)
                    right = decrease(right)
                } else if (nums[left] + nums[right] +nums[i]>0) {
                    right = decrease(right)
                } else {
                    left = increase(left)
                }
            }
            i = increase(i)
        }
        return answer
    }
}

fun main(args: Array<String>) {
    println(Solution15().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
}