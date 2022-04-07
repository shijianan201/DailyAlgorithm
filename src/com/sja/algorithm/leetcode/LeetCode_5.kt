package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_5 : IAlgorithmExecutor {

    override fun execute() {
        val res = longestPalindrome("ababab")
        println(res)
    }

    fun longestPalindrome(s: String): String {
        if (s.length <= 1) {
            return s
        }
        val res = Array(s.length) {
            Array(s.length) {
                true
            }
        }
        var begin = 0
        var max = 1
        for (l in 2..s.length) {
            for (i in 0 until s.length) {
                val j = l + i - 1 //末尾索引
                if (j >= s.length) {
                    break
                }
                if (s[i] != s[j]) {
                    res[i][j] = false
                } else {
                    if (j - i < 3) {
                        res[i][j] = true
                    } else {
                        res[i][j] = res[i + 1][j - 1]
                    }
                }
                if (res[i][j] && max < j - i + 1) {
                    begin = i
                    max = j - i + 1
                }
            }
        }
        return s.substring(begin, begin + max)
    }
}