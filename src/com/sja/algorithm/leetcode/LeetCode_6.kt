package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_6 : IAlgorithmExecutor {

    override fun execute() {
        val res = convert("ABCDEFGHIJKLMN",3)
        println(res)
    }

    fun convert(s: String, numRows: Int): String {
        if (s.length <= 1 || numRows <= 1 || numRows >= s.length) {
            return s
        }
        val strLen = s.length
        var row = 0
        var col = 0
        var strIndex = 0
        var down = true
        val arr = s.toCharArray()
        val sbArr = Array(numRows){
            StringBuilder()
        }
        while (strIndex < strLen) {
            sbArr[row].append(arr[strIndex])
            if (down) {
                if (row == numRows - 1) {
                    //到底了
                    row--
                    col++
                    down = !down
                } else {
                    row++
                }
            } else {
                if (row == 0) {
                    row++
                    down = !down
                } else {
                    row--
                    col++
                }
            }
            strIndex++
        }
        val sb = StringBuilder()
        sbArr.forEach {
            sb.append(it)
        }
        return sb.toString()
    }
}