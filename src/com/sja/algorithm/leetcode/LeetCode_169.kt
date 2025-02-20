package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor


class LeetCode_169: IAlgorithmExecutor {
    override fun execute() {

    }

    fun majorityElement(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(nums[i])) {
                val oldCnt = map[nums[i]]!!
                map[nums[i]] = oldCnt + 1
            } else {
                map[nums[i]] = 1
            }
        }
        var max = 0
        for (entry in map.entries) {
            val value: Int = entry.value
            if (value >= max) {
                max = value
            }
        }
        return max
    }
}