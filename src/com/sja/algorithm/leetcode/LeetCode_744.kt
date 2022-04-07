package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_744 : IAlgorithmExecutor {

    override fun execute() {
        val res = nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'z')
        println(res)
    }

    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        if(target >= letters[letters.size - 1]){
            return letters[0]
        }
        var left = 0
        var right = letters.size - 1
        while (left <= right) {
            val curPos = left + (right - left) / 2
            val cur = letters[curPos]
            if (left == right) {
                if (cur <= target) {
                    left = 0
                }
                break
            }
            if (cur <= target) {
                left = curPos + 1
            } else {
                right = curPos
            }
        }
        return letters[left]
    }
}