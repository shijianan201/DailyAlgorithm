package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_1791 : IAlgorithmExecutor {

    companion object{

        val arr = arrayOf(intArrayOf(1,2),intArrayOf(1,3),intArrayOf(4,1),intArrayOf(1,5))

    }

    override fun execute() {
        val res = findCenter(arr)
        println(res)
    }

    fun findCenter(edges: Array<IntArray>): Int {
        val map = hashMapOf<Int, Int>()
        edges.forEach {
            it.forEach { key ->
                val value = map[key]
                if (value == null) {
                    map[key] = 1
                } else {
                    map[key] = value + 1
                }
            }
        }
        return map.filter {
            it.value == edges.size
        }.keys.first()
    }
}