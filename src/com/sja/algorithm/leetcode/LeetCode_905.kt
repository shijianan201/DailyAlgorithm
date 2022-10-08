package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_905 : IAlgorithmExecutor {

    override fun execute() {
        val res = sortArrayByParity(intArrayOf(0,0,0))
        println(res.joinToString(","))
    }

    // 1,3,5,4,2
    // 2,3,5,4,1
    // 2,4,5,3,1
    fun sortArrayByParity(nums: IntArray): IntArray {
        if (nums.size <= 1) {
            return nums
        }
        var oddIndex = 0//奇数index
        var evenIndex = nums.size - 1//偶数index
        while (oddIndex < evenIndex) {
            while (oddIndex < evenIndex && nums[oddIndex] % 2 == 0) {
                oddIndex++
            }
            while (oddIndex < evenIndex  && nums[evenIndex] % 2 != 0) {
                evenIndex--
            }
            val temp = nums[oddIndex]
            nums[oddIndex] = nums[evenIndex]
            nums[evenIndex] = temp
            oddIndex++
            evenIndex--
        }
        return nums
    }
}