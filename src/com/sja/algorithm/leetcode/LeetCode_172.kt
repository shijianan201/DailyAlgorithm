package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_172 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun trailingZeroes(n: Int): Int {
        if(n == 0){
            return 0
        }
        var res = 0
        var loopNum = 0
        var multiNum = 1
        var multiFiveCount = 0
        var multiTenCount = 0
        while (loopNum <= n){
            val curFive = multiNum * 5
            val curTem = multiNum * 10
            if(loopNum == curFive){
                res += multiFiveCount + 1
            }
            if(loopNum == curTem){
                res += multiTenCount + 1
            }
            loopNum += 5
        }
        return res
    }
}