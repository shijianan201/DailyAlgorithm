package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_12 : IAlgorithmExecutor {

    private val singleArr = HashMap<Int, String>().apply {
        put(1, "I")
        put(4, "IV")
        put(5, "V")
        put(9, "IX")
        put(10, "X")
        put(40, "XL")
        put(50, "L")
        put(90, "XC")
        put(100, "C")
        put(400, "CD")
        put(500, "D")
        put(900, "CM")
        put(1000, "M")
    }

    private val numArr = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    private val charArr = arrayOf("M", "CM", "D", "CD", "C", "XC", "L","XL", "X", "IX", "V", "IV", "I")

    override fun execute() {
        val res = intToRoman(3999)
        println(res)
    }

    ////I             1
    ////V             5
    ////X             10
    ////L             50
    ////C             100
    ////D             500
    ////M             1000
    // 1234
    fun intToRoman(num: Int): String {
        val sb = StringBuffer()
        var res = num
        for (i in numArr.indices) {
            val keyNum = numArr[i]
            val ch = charArr[i]
            while (res >= keyNum) {
                res -= keyNum
                sb.append(ch)
            }
            if (num == 0) {
                break
            }
        }
        return sb.toString()
    }
}