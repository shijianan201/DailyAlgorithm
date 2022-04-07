package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_187 : IAlgorithmExecutor {

    override fun execute() {
        val res = findRepeatedDnaSequences("AAAAAAAAAAAAA")
        println(res.joinToString(","))
    }

    fun findRepeatedDnaSequences(s: String): List<String> {
        if(s.length <= 10){
            return arrayListOf()
        }
        val cache = hashSetOf<String>()
        val res = hashSetOf<String>()
        var start = 0
        while (start <= s.length - 10){
            val temp = s.substring(start,start+10)
            if(cache.contains(temp)){
                res.add(temp)
            }
            cache.add(temp)
            start++
        }
        return res.toList()
    }
}