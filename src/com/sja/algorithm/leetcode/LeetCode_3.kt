package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
// abcbbababbbc
class LeetCode_3:IAlgorithmExecutor {

    override fun execute() {
        println("无重复字符的最长子串")
        val testStr = Consts.STRING_LEN_20
        println("原始字符串：$testStr")
        println("长度为："+getMaxLen(testStr))
    }

    private fun getMaxLen(s:String):Int{
        val len = s.length
        if(len <= 1){
            return len
        }
        var res = 1
        var left = 0
        var right = 1
        val cacheSet = arrayListOf<Char>()
        cacheSet.add(s.elementAt(left))
        var resStr = String(cacheSet.toCharArray())
        while (right < len){
            val rightChar = s.elementAt(right)
            val indexOfRight = cacheSet.indexOf(rightChar)
            if(indexOfRight >= 0){
                for(j in 0..indexOfRight){
                    cacheSet.removeFirst()
                }
                left += indexOfRight + 1
            }else{
                cacheSet.add(rightChar)
                right++
            }
            if(cacheSet.size > res){
                res = cacheSet.size
                resStr = String(cacheSet.toCharArray())
            }
        }
        println("结果：$resStr")
        return res
    }
}