package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import kotlin.math.sin

//0，1，2，3
//4，3，2，5，4，3，2，5
//4，3，2，5 0*4+1*3+2*2+3*5 F(0,n-1) = (n-1)*arr[n-1] + G(n-1) = 22
//3，2，5，4 0*3+1*2+2*5+3*4 F(1,n) = F(0,n-1) - sum(0,n-1) + (n-1) * arr[0] * 4
//2，5，4，3 0*2+1*5+2*4+3*3 F(2,n+1) = F(1,n) - sum(0,n-1) + (n-1) * arr[1] * 4
//5，4，3，2 0*5+1*4+2*3+3*2 F(3,n+2) = F(2,n+1) - sum(0,n-1) + (n-1) * arr[2] * 4
class LeetCode_396 : IAlgorithmExecutor {

    override fun execute() {
        val res = maxRotateFunction(intArrayOf(4, 3, 2, 6))
        println(res)
    }

    fun maxRotateFunction(nums: IntArray): Int {
        var singleSum = 0
        var pre = 0
        for (i in 0 until nums.size) {
            singleSum += nums[i]
            pre += nums[i] * i
        }
        var max = pre
        for (i in 1 until nums.size) {
            pre = pre - singleSum + nums[i - 1] * nums.size
            if (pre > max) {
                max = pre
            }
        }
        return max
    }
}