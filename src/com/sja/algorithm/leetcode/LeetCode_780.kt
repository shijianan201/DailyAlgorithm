package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_780 : IAlgorithmExecutor {

    override fun execute() {
        val res = reachingPoints(-1,-1,3,5)
        println(res)
    }

    fun reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
        if (sx > tx || sy > ty) {
            return false
        }
        if (sx == tx && sy == ty) {
            return true
        }
        val left = reachingPoints(sx + sy, sy, tx, ty)
        if (left) {
            return left
        }
        return reachingPoints(sx, sx + sy, tx, ty)
    }

}