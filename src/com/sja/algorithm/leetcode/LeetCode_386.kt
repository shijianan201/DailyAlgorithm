package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_386 : IAlgorithmExecutor {

    override fun execute() {
        val res = lexicalOrder(13)
        println(res.joinToString(","))
    }

    fun lexicalOrder(n: Int): List<Int> {
        val res = ArrayList<Int>()
        for (i in 1..9) {
            dfs(res, n, i)
        }
        return res
    }

    fun dfs(res: ArrayList<Int>, n: Int, parentNum: Int) {
        if (parentNum > n) {
            return
        }
        res.add(parentNum)
        val startNum = parentNum * 10
        val endNum = parentNum * 10 + 9
        for (num in startNum..endNum) {
            if (num > n) {
                break
            }
            dfs(res, n, num)
        }
    }
}