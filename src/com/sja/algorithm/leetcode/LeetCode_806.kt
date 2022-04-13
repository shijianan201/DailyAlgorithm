package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_806 : IAlgorithmExecutor {

    override fun execute() {
        val res = numberOfLines(intArrayOf(10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10),"abcdefghijklmnopqrstuvwxyz")
        println(res.joinToString(","))
    }

    fun numberOfLines(widths: IntArray, s: String): IntArray {
        var lines = 0
        var bottomWidth = 0
        var currentLineWidth = 0
        s.forEach {
            val width = widths[it - 'a']
            if (currentLineWidth + width > 100) {
                lines++
                currentLineWidth = width
            } else {
                currentLineWidth += width
                bottomWidth = currentLineWidth
            }
        }
        return intArrayOf(lines + 1, bottomWidth)
    }
}