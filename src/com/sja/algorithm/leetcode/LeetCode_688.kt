package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_688 : IAlgorithmExecutor {

    override fun execute() {
        val res = knightProbability(3, 2, 0, 0)
        println(res)
    }

    fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
        if(k == 0){
            return 1.0000
        }
        val res = dfs(n, k, row, column)
        return res / Math.pow(8.0,k.toDouble())
    }

    fun dfs(n: Int, k: Int, row: Int, column: Int): Int {
        if(row >=n || column >= n || row < 0 || column < 0){
            return 0
        }
        if(k == 0){
            return 1
        }
        val first = dfs(n, k - 1, row - 2, column - 1)
        val second = dfs(n, k - 1, row - 1, column - 2)
        val third = dfs(n, k - 1, row + 1, column - 2)
        val forth = dfs(n, k - 1, row + 2, column - 1)
        val fifth = dfs(n, k - 1, row + 2, column + 1)
        val sixth = dfs(n, k - 1, row + 1, column + 2)
        val seventh = dfs(n, k - 1, row - 1, column + 2)
        val eight = dfs(n, k - 1, row - 2, column + 1)
        return first + second + third + forth + fifth + sixth + seventh + eight
    }

}