package medium

import java.util.*

class Solution120 {

    fun minimumTotal(triangle: List<List<Int>>): Int {
        var temp = LinkedList<Int>()
        var result = LinkedList<Int>()
        result.addAll(triangle[triangle.size - 1])
        for (i in triangle.size - 2 downTo 0) {
            temp = result
            result = LinkedList<Int>()
            for (j in 0 until triangle[i].size) {
                result.add(triangle[i][j] + Math.min(temp[j], temp[j + 1]))
            }
        }
        return result[0]
    }

}