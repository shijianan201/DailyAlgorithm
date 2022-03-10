package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_1438 : IAlgorithmExecutor {

    override fun execute() {
        val res = longestSubarray(intArrayOf(10,1,2,4,7,2),5)
        println(res)
    }

    fun longestSubarray(nums: IntArray, limit: Int): Int {
        if(nums.isEmpty() || nums.size == 1){
            return nums.size
        }
        val resArr = IntArray(nums.size)
        resArr[0] = 1
        var res = resArr[0]
        for (i in 1 until nums.size){
            if(Math.abs(nums[i] - nums[i-1]) <= limit){
                resArr[i] = Math.max(resArr[i-1]+1,1)
            }else{
                resArr[i] = 1
            }
            if(resArr[i] > res){
                res = resArr[i]
            }
        }
        return res
    }
}