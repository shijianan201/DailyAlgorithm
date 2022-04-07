package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*
import kotlin.math.abs

class LeetCode_16 : IAlgorithmExecutor {

    override fun execute() {
        val res = threeSumClosest(intArrayOf(-1,2,1,-4),1)
        println(res)
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        if (nums.size == 3) {
            return nums.sum()
        }
        Arrays.sort(nums)
        var res = Int.MAX_VALUE
        var minDiff = Int.MAX_VALUE
        for (first in nums.indices) {
            for (second in first + 1 until nums.size) {
                for (third in second + 1 until nums.size) {
                    val sum = nums[first] + nums[second] + nums[third]
                    val diff = abs(target - sum)
                    if (diff == 0) {
                        return sum
                    }
                    if (diff < minDiff) {
                        minDiff = diff
                        res = sum
                    }
                }
            }
        }
        return res
    }
}