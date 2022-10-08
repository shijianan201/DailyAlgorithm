package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_35 : IAlgorithmExecutor {

    override fun execute() {
    }

    //1 2 3 4 5
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1
        while (start < end) {
            val mid = start + (end - start) / 2
            val midNum = nums[mid]
            if (midNum == target) {
                return mid
            } else if (midNum < target) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return start
    }
}