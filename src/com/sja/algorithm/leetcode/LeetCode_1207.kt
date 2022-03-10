package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor


class LeetCode_1207 : IAlgorithmExecutor {

    override fun execute() {
        val res = method_1(intArrayOf())
    }

    private fun method_1(arr: IntArray): Boolean {
        val map = HashMap<Int, Int>()
        arr.forEach {
            map[it] = map.getOrDefault(it,0)+1
        }
        val set = HashSet<Int>()
        map.entries.forEach {
            set.add(it.value)
        }
        return set.size == map.size
    }
}