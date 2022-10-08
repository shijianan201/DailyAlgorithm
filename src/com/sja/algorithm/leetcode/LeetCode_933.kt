package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*

class LeetCode_933 : IAlgorithmExecutor {

    override fun execute() {
        method_1()
    }

    private fun method_1() {

    }
}

class RecentCounter() {

    val queue = LinkedList<Int>()

    fun ping(t: Int): Int {
        while (!queue.isEmpty()) {
            val top = queue.peek()
            if (t - top > 3000) {
                queue.poll()
            }
        }
        queue.offer(t)
        return queue.size
    }

}