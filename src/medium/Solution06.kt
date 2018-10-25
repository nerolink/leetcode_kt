package medium

import java.lang.StringBuilder
import java.util.*

class Solution06 {
    fun convert(s: String, numRows: Int): String {
        val listArray = arrayOfNulls<LinkedList<Char>>(numRows)
        for (i in 0 until numRows) {
            listArray[i]=LinkedList<Char>()
        }
        var flip=false
        for (i in 0 until s.length) {
            val index=if (flip) numRows-2-i%numRows else i%numRows
            listArray[index]?.add(s[i])
            if ((i+1) % numRows == 0) {
                flip=flip&&false
            }
        }
        val sb = StringBuilder()
        for (i in 0 until numRows) {
            for (j in 0 until listArray[i]!!.size) {
                sb.append(listArray[i]!!.get(j))
            }
        }
        return sb.toString()
    }
}

class Solution06_2 {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }
        var x = 0
        var y = 0
        val listArray = arrayOfNulls<LinkedList<Char>>(numRows)
        for (i in 0 until numRows) listArray[i]=LinkedList()
        var flip=false
        for (i in 0 until s.length) {
            listArray[y]?.add(s[i])
            if (!flip) {
                if (y + 1 == numRows) {
                    y--
                    flip=true
                } else y++
            } else {
                if (y==0){
                    y++
                    flip=false
                } else y--
            }
        }
        val sb = StringBuilder()
        for (i in 0 until numRows) {
            for (j in 0 until listArray[i]!!.size) {
                sb.append(listArray[i]!!.get(j))
            }
        }
        return sb.toString()
    }
}

fun main(args: Array<String>) {
    println(Solution06().convert("PAYPALISHIRING", 3))

}