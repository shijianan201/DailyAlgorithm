package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_868 : IAlgorithmExecutor {

    override fun execute() {
        val res = binaryGap(22)
        println(res)
    }

    fun binaryGap(n: Int): Int {
        var max = Int.MIN_VALUE
        var preIndex:Int? = null
        var number = n
        var loopCount = 0
        while (number > 0){
            val remain = number % 2
            if(remain == 1){
                //当前是1
                if(preIndex != null){
                    //前面有1,更新max
                    max = Math.max(max,Math.abs(loopCount - preIndex))
                }
                preIndex = loopCount
            }
            number /= 2
            loopCount++
        }
        return if(max < 0) 0 else max
    }
}