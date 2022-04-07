package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import kotlin.math.min

class LeetCode_440 : IAlgorithmExecutor {

    override fun execute() {
        val res = findKthNumber(100, 35)
        println(res)
    }

    fun findKthNumber(n: Int, k: Int): Int {
        var curr = 1
        var tk = k
        tk--
        while (tk > 0){
            val steps = getSteps(curr,n.toLong())
            if(steps <= tk){
                tk -= steps
                curr++
            }else{
                curr *= 10
                tk--
            }
        }
        return curr
    }

    fun getSteps(curr: Int, n: Long): Int {
        var steps: Long = 0
        var first: Long = curr.toLong()
        var last: Long = curr.toLong()
        while (first <= n) {
            steps += min(last, n) - first + 1
            first *= 10
            last = last * 10 + 9
        }
        return  steps.toInt()
    }
}