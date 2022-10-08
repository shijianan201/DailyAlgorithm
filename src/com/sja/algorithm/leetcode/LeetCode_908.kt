package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*
import kotlin.math.abs

class LeetCode_908 : IAlgorithmExecutor {

    override fun execute() {
        val res = smallestRangeI(intArrayOf(2,7,2),2)
        println(res)
    }

    // 1 3 5 7    2
    // 3,-1 1 5
    fun smallestRangeI(nums: IntArray, k: Int): Int {
        if (nums.size <= 1) {
            return 0
        }
        if(k == 0){
            return nums[nums.size - 1] - nums[0]
        }
        Arrays.sort(nums)
        val firstMax = nums[0] + k
        val endMin = nums[nums.size-1] - k
        return if(endMin >= firstMax){
            Math.abs(endMin-firstMax)
        }else{
            0
        }
    }
}