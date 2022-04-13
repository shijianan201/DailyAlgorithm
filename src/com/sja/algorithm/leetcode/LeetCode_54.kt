package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_54 : IAlgorithmExecutor {

    override fun execute() {
        val res = spiralOrder(arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,6,7,8), intArrayOf(9,10,11,12)))
        println(res.joinToString(","))
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var row = 0
        var column = 0
        val rowCount = matrix.size
        val columnCount = matrix[0].size
        val size = rowCount * columnCount
        var loopCount = 0
        val res = ArrayList<Int>()
        var loopType = 1 // 1：最上层左到右，2：最右边上到下，3：最下边右到左，4：最左边下到上
        var loopedCount = 0
        while (loopCount < size) {
            res.add(matrix[row][column])
            when (loopType) {
                1 -> {
                    if (column == columnCount - 1 - loopedCount) {
                        loopType = 2
                        row++
                    } else {
                        column++
                    }
                }
                2 -> {
                    if (row == rowCount - 1 - loopedCount) {
                        loopType = 3
                        column--
                    } else {
                        row++
                    }
                }
                3 -> {
                    if (column == 0 + loopedCount) {
                        loopType = 4
                        loopedCount++
                        row--
                    } else {
                        column--
                    }
                }
                4 -> {
                    if (row == 0 + loopedCount) {
                        loopType = 1
                        column++
                    } else {
                        row--
                    }
                }
                else -> {

                }
            }
            loopCount++
        }
        return res
    }
}