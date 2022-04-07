package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import kotlin.math.max

class LeetCode_55 : IAlgorithmExecutor {

    override fun execute() {
        val res = canJump(intArrayOf(2, 3, 1, 1, 4))
        println(res)
    }

    fun canJump(nums: IntArray): Boolean {
        if (nums.size == 1) {
            return nums[0] > 0
        }
        var max = Int.MIN_VALUE
        for (i in 0 until nums.size) {
            max = if(i == 0){
                0 + nums[0]
            }else{
                max(max,i+nums[i])
            }
            if(max >= nums.size){
                return true
            }
        }
        return false
    }
}
