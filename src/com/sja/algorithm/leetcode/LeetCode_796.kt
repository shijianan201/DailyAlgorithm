package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_796 : IAlgorithmExecutor {

    override fun execute() {
        val res = rotateString("aa","a")
        println(res)
    }

    // abcdeabcde
    fun rotateString(s: String, goal: String): Boolean {
        if (goal.length != s.length) {
            return false
        }
        val gLen = goal.length
        val ss = "$s$s"
        var pos = 0
        while (pos < ss.length - gLen) {
            val str = ss.substring(pos, pos + gLen)
            if (str == goal) {
                return true
            }
            pos++
        }
        return false
    }
}