package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.lang.StringBuilder

class LeetCode_38 : IAlgorithmExecutor {

    override fun execute() {
        val res = countAndSay(30)
        println(res)
    }

    fun countAndSay(n: Int): String {
        if (n == 1) {
            return "1"
        }
        var res = "1"
        var index = 1
        while (index < n) {
            val sb = StringBuilder()
            val arr = res.toCharArray()
            var currentChar = res[0]
            var currentCount = 1
            for (i in 1..arr.size) {
                if (i == arr.size || arr[i] != currentChar) {
                    sb.append(currentCount)
                    sb.append(currentChar)
                    if(i < arr.size) {
                        currentChar = arr[i]
                        currentCount = 1
                    }
                } else {
                    currentCount++
                }
            }
            res = sb.toString()
            index++
        }
        return res
    }
}