package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_1837 : IAlgorithmExecutor {

    override fun execute() {
        val res = sumBase(50,2)
        println(res)
    }

    fun sumBase(n: Int, k: Int): Int {
        var sum = 0
        var num = n
        while (num > 0){
            val remain = num % k
            sum += remain
            num /= k
        }
        return sum
    }
}