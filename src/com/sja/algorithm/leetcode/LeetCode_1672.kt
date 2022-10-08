package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_1672 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun maximumWealth(accounts: Array<IntArray>): Int {
        var maxWealth = Int.MIN_VALUE
        accounts.forEach {
            val sum = it.sum()
            if(sum > maxWealth){
                maxWealth = sum
            }
        }
        return maxWealth
    }
}