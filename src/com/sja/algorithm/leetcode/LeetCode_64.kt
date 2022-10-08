package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_64 : IAlgorithmExecutor {

    override fun execute() {
        val res = minPathSum(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6)))
        println(res)
    }

    fun minPathSum(grid: Array<IntArray>): Int {
        val res = IntArray(grid[0].size)
        for (row in grid.indices){
            for (column in 0 until grid[0].size){
                val  num = grid[row][column]
                if (row == 0 && column == 0) {
                    res[column] = num
                } else {
                    if(row == 0){
                        res[column] = num + res[column-1]
                    }else{
                        if (column == 0) {
                            res[column] = res[column] + num
                        } else {
                            res[column] = Math.min(num + res[column - 1], num + res[column])
                        }
                    }
                }
            }
        }
        return res[grid[0].size - 1]
    }
}