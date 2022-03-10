package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_11 : IAlgorithmExecutor {

    override fun execute() {
        val arr = intArrayOf(1,8,6,2,5,4,8,3,7)
        val maxArea = maxArea(arr)
        println(maxArea)
    }

    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size-1
        var res = 0
        while (left < right){
            val leftVal = height[left]
            val rightVal = height[right]
            val cur = Math.min(leftVal,rightVal) * (right - left)
            if(cur > res){
                res = cur
            }
            if(leftVal < rightVal){
                left++
            }else{
                right--
            }
        }
        return res
    }
}