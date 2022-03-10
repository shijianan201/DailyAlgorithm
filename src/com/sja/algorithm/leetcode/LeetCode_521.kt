package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_521 : IAlgorithmExecutor {

    override fun execute() {
        val aStr = "aaa"
        val bStr = "bba"
        val res = findLUSlength(aStr,bStr)
        println(res)
    }

    fun findLUSlength(a: String, b: String): Int {
        if (a == b) {
            return -1
        }
        return a.length.coerceAtLeast(b.length)
    }
}