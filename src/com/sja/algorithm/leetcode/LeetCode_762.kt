package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_762 : IAlgorithmExecutor {

    override fun execute() {
        val res = countPrimeSetBits(6,10)
        println(res)
    }

    fun countPrimeSetBits(left: Int, right: Int): Int {
        var count = 0
        for (num in left..right){
            var numCnt = 0
            var tmp = num
            while (tmp > 0){
                val n = tmp % 2
                if(n == 1){
                    numCnt++
                }
                tmp /= 2
            }
            if(isPrime(numCnt)){
                count++
            }
        }
        return count
    }

    fun isPrime(num:Int):Boolean{
        if(num == 1){
            return false
        }
        if(num == 2 || num == 3){
            return true
        }
        for (i in 2 until num){
            if(num % i == 0){
                return false
            }
        }
        return true
    }
}