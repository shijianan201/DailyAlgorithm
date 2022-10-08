package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_60 : IAlgorithmExecutor {

    override fun execute() {
        val res = getPermutation(3,3)
        println(res)
    }

    fun getPermutation(n: Int, k: Int): String {
        var res = ""
        var subN = n
        var subK = k-1
        val list = arrayListOf<Int>()
        for (i in 1..n){
            list.add(i)
        }
        while (list.size > 0){
            val sumN = sumN(subN)
            val first = subK / sumN
            res = "$res${list.get(first)}"
            list.removeAt(first)
            subK %= sumN
            subN--
        }
        return res
    }

    fun sumN(n:Int):Int{
        var res = 1
        var cur = 2
        while (cur < n){
            res *= cur
            cur++
        }
        return res
    }
}