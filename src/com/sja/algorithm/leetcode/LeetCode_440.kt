package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import kotlin.math.min

class LeetCode_440 : IAlgorithmExecutor {

    override fun execute() {
        val res = findKthNumber(13, 2)
        println(res)
    }

    fun findKthNumber(n: Int, k: Int): Int {
        val res = ArrayList<Int>()
        for (i in 1..9) {
            dfs(res, n, i)
        }
        return res.get(k-1)
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