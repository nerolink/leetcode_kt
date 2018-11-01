package hard

class Solution04 {


//    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
//        if (nums1.isEmpty()) {
//            if (nums2.size % 2 == 1) {
//                return (nums2[nums2.size / 2] + nums2[nums2.size / 2 - 1]) * 1.0 / 2
//            } else {
//                return nums2[nums2.size / 2] * 1.0
//            }
//        }
//        if (nums2.isEmpty()) {
//            if (nums1.size % 2 == 1) {
//                return (nums1[nums1.size / 2] + nums1[nums1.size / 2 - 1]) * 1.0 / 2
//            } else {
//                return nums1[nums1.size / 2] * 1.0
//            }
//        }
//
//
//        var size: Int = nums1.size + nums2.size
//        var bound1 = nums1.size - 1
//        var bound2 = nums2.size - 1
//        var idx1 = 0
//        var idx2 = 0
//        var current = Int.MIN_VALUE
//        var last = Int.MIN_VALUE
//        val targetIndex = size / 2
//        var currIndex = -1
//        while (currIndex != targetIndex) {
//            last = current
//            if (nums1[idx1] < nums2[idx2]) {
//                current = nums1[idx1]
//                if (idx1 < bound1) {
//                    idx1++
//                } else {
//                    currIndex = targetIndex
//                    if (idx2 + targetIndex - idx1 - 1 < 0) {
//                        last = nums1[idx1]
//                    } else {
//                        last = nums2[idx2 + targetIndex - idx1 - 1]
//                    }
//                    current = nums2[idx2 + targetIndex - idx1]
//                }
//            } else {
//                current = nums2[idx2]
//                if (idx2 < bound2) {
//                    idx2++
//                } else {
//                    idx1++
//                }
//            }
//            currIndex++
//        }
//        if (size % 2 == 1) return current + 0.0
//        return (last + current) * 1.0 / 2
//    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val a = if (nums1.size > nums2.size) nums2 else nums1
        val b = if (nums1.size > nums2.size) nums1 else nums2
        val m = a.size
        val n = b.size
        var i = 0       //用于表示a放左边的个数
        var j = (m + n + 1) / 2 - i     //用于表示b放左边的个数
        fun update_j() {
            j = (m + n + 1) / 2 - i
        }

        fun get_edge_left(num: Int, array: IntArray): Int {
            if (num <= 0) {
                return Int.MIN_VALUE
            }
            return array[num - 1]
        }

        fun get_edge_right(num: Int, array: IntArray): Int {
            if (num >= array.size) {
                return Int.MAX_VALUE
            }
            return array[num]
        }

        while (true) {
            if ((i > 0 || j == 0) && a[i - 1] > b[j]) {
                i--
                update_j()
            } else if ((j > 0 || i == 0) && b[j - 1] > a[i]) {
                i++
                update_j()
            } else {
                break
            }
        }
        if ((m + n) % 2 == 1) {
            return Math.max(get_edge_left(i, a), get_edge_left(j, b)) * 1.0
        } else {
            return (Math.max(get_edge_left(i, a), get_edge_left(j, b)) + Math.min(get_edge_right(i, a), get_edge_right(j, b))) * 1.0 / 2
        }
    }
}

fun main(args: Array<String>) {
    print(Solution04().findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
}