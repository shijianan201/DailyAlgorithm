package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_41 : IAlgorithmExecutor {

    override fun execute() {
        val res = firstMissingPositive(intArrayOf(-2,3,9,2,4,8,7,2,-2,5,6))
        println(res)
    }

    fun firstMissingPositive(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 1
        }
        for (i in nums.indices) {
            while (nums[i] >= 1 && nums[i] < nums.size && nums[i] != nums[nums[i] - 1]) {
                val temp = nums[nums[i]-1]
                nums[nums[i] - 1] = nums[i]
                nums[i] = temp
            }
        }
        for (i in nums.indices) {
            if (nums[i] != i + 1) {
                return i + 1
            }
        }
        return nums.size + 1
    }
}