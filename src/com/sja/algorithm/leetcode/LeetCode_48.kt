package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_48 : IAlgorithmExecutor {

    override fun execute() {
        val arr = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(16, 17, 18, 19, 20),
            intArrayOf(21, 22, 23, 24, 25)
        )
        rotate(arr)
        arr.forEach {
            println(it.joinToString(","))
        }
    }

    fun rotate(matrix: Array<IntArray>) {
        val rowCount = matrix.size
        for (row in 0 until rowCount / 2) {
            for (column in 0 until (rowCount + 1) / 2) {
                val temp = matrix[row][column] // 0,1 2,0
                matrix[row][column] = matrix[rowCount - column - 1][row]
                matrix[rowCount - column - 1][row] = matrix[rowCount - 1 - row][rowCount - column - 1]
                matrix[rowCount - 1 - row][rowCount - column - 1] = matrix[column][rowCount - 1 - row]
                matrix[column][rowCount - 1 - row] = temp
            }
        }
    }
}