package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import kotlin.math.max

class LeetCode_53 : IAlgorithmExecutor {

    override fun execute() {
        val res = maxSubArray(intArrayOf(5,4,-1,7,8))
        println(res)
    }

    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }
        val resArr = IntArray(nums.size)
        resArr[0] = nums[0]
        var res = nums[0]
        for (i in 1 until nums.size){
            resArr[i] = Math.max(resArr[i-1] + nums[i],nums[i])
            if(resArr[i] > res){
                res = resArr[i]
            }
        }
        return res
    }
}