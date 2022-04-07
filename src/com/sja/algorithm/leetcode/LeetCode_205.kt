package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_205 : IAlgorithmExecutor {

    override fun execute() {
        val res = isIsomorphic("egg","abb")
        println(res)
    }

    fun isIsomorphic(s: String, t: String): Boolean {
        if(s.length != t.length){
            return false
        }
        // foo bar egg abb
        val cache = hashMapOf<Char,Char>()
        val cache1 = hashMapOf<Char,Char>()
        for (i in 0 until s.length){
            val sCh = s.get(i)
            val tCh = t.get(i)
            val cacheS = cache.get(sCh)
            val cacheT = cache1.get(tCh)
            if(cacheS == null && cacheT == null){
                cache.put(sCh,tCh)
                cache1.put(tCh,sCh)
            }else{
                if(cacheT != sCh || cacheS != tCh){
                    return false
                }
            }
        }
        return true
    }
}