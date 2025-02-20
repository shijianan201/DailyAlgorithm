package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*

class LeetCode_821 : IAlgorithmExecutor {

    override fun execute() {
        val res = shortestToChar("abaa", 'a')
        println(res.joinToString(","))
    }

    //loveleetcode
    fun shortestToChar(s: String, c: Char): IntArray {
        val queue = LinkedList<Int>()
        for (i in 0 until s.length) {
            if (s.get(i) == c) {
                queue.offer(i)
            }
        }
        val res = IntArray(s.length)
        var pre = s.length
        var end = queue.poll()
        for (i in 0 until s.length) {
            val ch = s.get(i)
            if (ch == c) {
                res[i] = 0
                pre = end
                end = if(queue.isEmpty()) -1 else queue.poll()
            } else {
                res[i] = Math.min(Math.abs(i-pre),Math.abs(i-end))
            }
        }
        return res
    }
}