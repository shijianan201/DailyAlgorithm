package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_728 : IAlgorithmExecutor {

    override fun execute() {
        val res = selfDividingNumbers(47,85)
        println(res.joinToString(","))
    }

    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        val res = arrayListOf<Int>()
        for (num in left..right) {
            var cur = num
            while (cur > 0){
                val remain = cur % 10
                if(remain == 0){
                    break
                }else if(num % remain == 0){
                    cur /= 10
                    continue
                }else{
                    break
                }
            }
            if(cur == 0){
                res.add(num)
            }
        }
        return res
    }
}