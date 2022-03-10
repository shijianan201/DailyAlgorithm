package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_2100 : IAlgorithmExecutor {

    override fun execute() {
//        method_1()
    }

    // 1,2,3,4,6 2
    fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {
        if(time <= 0){
            return security.toList()
        }
        if(security.size < (time * 2 + 1)){
            return arrayListOf()
        }
        var start = time
        var end = security.size - time
        while (start < end){

        }
        return arrayListOf()
    }
}