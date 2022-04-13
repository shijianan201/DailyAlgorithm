package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_357 : IAlgorithmExecutor {

    override fun execute() {
        val res = countNumbersWithUniqueDigits(3)
        println(res)
    }

    fun countNumbersWithUniqueDigits(n: Int): Int {
        if(n == 0){
            return 1
        }
        if(n == 1){
            return 1 + 9
        }
        var res = 10
        var temp = 9
        var remain = 9
        for (i in 2..n){
            res += temp * remain
            temp *= remain
            remain--
        }
        return res
    }
}