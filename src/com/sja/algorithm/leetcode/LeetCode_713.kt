package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_713 : IAlgorithmExecutor {

    override fun execute() {
        val res = numSubarrayProductLessThanK(IntArray(1000) {
            1
        }, 100)
        println(res)
    }

    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if (k == 0) {
            return 0
        }
        var count = 0
        var startIndex = 0
        while (startIndex < nums.size) {
            var sum = 1
            var start = startIndex
            while (sum < k && start < nums.size) {
                while (start < nums.size && nums[start] == 1) {
                    count++
                    start++
                }
                if (start < nums.size) {
                    sum *= nums[start]
                    if (sum < k) {
                        count++
                    }
                }
                start++
            }
            startIndex++
        }
        return count
    }

}