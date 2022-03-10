package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import kotlin.math.abs

class LeetCode_504 : IAlgorithmExecutor {

    override fun execute() {
        val res = convertToBase7(-7)
        println(res)
    }

    fun convertToBase7(num: Int): String {
        if(num == 0){
            return "0"
        }
        var sb = ""
        val belowZero = num < 0
        var n = Math.abs(num)
        while (n != 0){
            val remain = n % 7
            sb = "$remain$sb"
            n /= 7
        }
        return if(belowZero) "-$sb" else sb
    }
}