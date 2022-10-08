package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_1037 : IAlgorithmExecutor {

    override fun execute() {
        val res = isBoomerang(arrayOf(intArrayOf(0,2),intArrayOf(2,1),intArrayOf(0,0)))
        println(res)
    }

    /**
     * x轴不完全相同，y不完全相同，y差值/x差值 比例不同
     */
    fun isBoomerang(points: Array<IntArray>): Boolean {
        val first = points[0]
        val second = points[1]
        val third = points[2]
        val xSame = first[0] == second[0] && second[0] == third[0]
        if(xSame){
            return false
        }
        val ySame = first[1] == second[1] && second[1] == third[1]
        if(ySame){
            return false
        }
        val xd1 = second[0]-first[0]
        val yd1 = second[1]-first[1]

        val xd2 = second[0]-third[0]
        val yd2 = second[1]-third[1]
        return yd2 * xd1 != xd2 * yd1
    }
}