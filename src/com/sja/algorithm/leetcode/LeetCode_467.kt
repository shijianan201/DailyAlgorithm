package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import kotlin.math.abs

class LeetCode_467 : IAlgorithmExecutor {

    override fun execute() {
        val res = findSubstringInWraproundString("cac")
        println(res)
    }

    fun findSubstringInWraproundString(p: String): Int {
        val len = p.length
        val cache = Array(len) {
            Array(len) {
                false
            }
        }
        var cnt = 0
        val list = hashSetOf<String>()
        for (row in 0 until len) {
            for (column in 0 until len) {
                if (row == column) {
                    cache[row][column] = true
                    if(!list.contains("${p.get(row)}")) {
                        cnt++
                    }
                    list.add("${p.get(row)}")
                } else if (row > column) {
                    cache[row][column] = false
                }
            }
        }
        for (s in 2..len) {
            list.clear()
            for (start in 0..(len - s)) {
                val end = start + s - 1
                cache[start][end] =
                    cache[start][end - 1] && (p[end] - p[end - 1] == 1 || Math.abs(p[end] - p[end - 1]) == 25)
                val str = p.substring(start, end + 1)
                if (cache[start][end] && !list.contains(str)) {
                    cnt++
                }
                list.add(str)
            }
        }
        return cnt
    }
}