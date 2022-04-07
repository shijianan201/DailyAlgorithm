package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_80 : IAlgorithmExecutor {

    override fun execute() {
        val arr = intArrayOf(1, 2, 2, 3, 3, 4, 5, 6)
        val res = removeDuplicates(arr)
        println("${arr.joinToString(",")} $res")
    }

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 1) {
            return nums.size
        }
        var pre = -1
        var startIndex = 0
        var moveIndex = 1
        var preDuplicate = false
        while (moveIndex < nums.size) {
            if (nums[startIndex] == nums[moveIndex]) {
                preDuplicate = true
                moveIndex++
            } else {
                if (preDuplicate) {
                    startIndex = moveIndex
                    moveIndex++
                } else {
                    pre++
                    startIndex++
                    moveIndex++
                }
                preDuplicate = false
            }
        }
        return pre + 1
    }
}