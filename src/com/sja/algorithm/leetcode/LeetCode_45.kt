package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_45 : IAlgorithmExecutor {

    override fun execute() {
        val res = jump(intArrayOf(2,3,1,1,4))
        println(res)
    }

    fun jump(nums: IntArray): Int {
        if (nums.size <= 1) {
            return nums.size
        }
        var step = 0
        var startPos = 0
        while (startPos < nums.size) {
            val max = startPos + nums[startPos]
            if (max > nums.size - 2) {
                step++
                break
            } else {
                var curMax = -1
                for (i in startPos..max) {
                    val p = i + nums[i]
                    if(p > curMax){
                        startPos = i
                        curMax = p
                    }
                }
                step++
            }
        }
        return step
    }
}