package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_13 : IAlgorithmExecutor {

    companion object{
        val dic = hashMapOf<Char,Int>().apply {
            put('I',1)
            put('V',5)
            put('X',10)
            put('L',50)
            put('C',100)
            put('D',500)
            put('M',1000)
        }
    }

    override fun execute() {
        val res = romanToInt("IX")
        println(res)
    }

    fun romanToInt(s: String): Int {
        var res = 0
        val chArr = s.toCharArray()
        for (i in chArr.indices){
            val ch = chArr[i]
            if(i < chArr.size-1 && dic[ch]!! < dic[ch+1]!!){
                res -= dic[ch]!!
            }else{
                res += dic[ch]!!
            }
        }
        return res
    }
}