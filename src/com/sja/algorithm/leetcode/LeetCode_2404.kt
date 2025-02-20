package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.TreeSet

class LeetCode_2404 : IAlgorithmExecutor {
    override fun execute() {
        val arr = intArrayOf(1, 3, 2, 2, 2, 2, 4, 5, 5, 6, 6, 6, 6, 8, 9, 3, 1)
        println(findMinFrequencyEvenNumber(arr))
    }

    fun findMinFrequencyEvenNumber(arr: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        arr.forEach {
            if (it % 2 == 0) {
                map.put(it, map.getOrDefault(it, 0) + 1)
            }
        }
        if (map.isEmpty()) {
            return -1
        }
        val sets = TreeSet<Number2404>()
        for (entry in map) {
            sets.add(Number2404(entry.key, entry.value))
        }
        return sets.firstOrNull()?.number ?: -1
    }
}

data class Number2404(val number: Int, val cnt: Int) : Comparable<Number2404> {
    override fun compareTo(other: Number2404): Int {
        return if (this.cnt < other.cnt) {
            1
        } else {
            if (this.cnt == other.cnt) {
                number - other.number
            } else {
                -1
            }
        }
    }
}