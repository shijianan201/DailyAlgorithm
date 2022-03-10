package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_14 : IAlgorithmExecutor {

    override fun execute() {
        val arr = arrayOf("xflower","flow","flight")
        val res = longestCommonPrefix(arr)
        println(res)
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if(strs.isEmpty()){
            return ""
        }
        if(strs.size == 1){
            return strs[0]
        }
        val res = arrayListOf<Char>()
        res.addAll(strs[0].toCharArray().toList())
        if(res.isEmpty()){
            return ""
        }
        var commonCount = Int.MAX_VALUE
        for (i in 1 until strs.size){
            var commonIndex = 0
            val curArr = strs[i].toCharArray()
            for (j in curArr.indices){
                if(j >= res.size){
                    break
                }
                if(res[j] == curArr[j]){
                    commonIndex++
                }else{
                    break
                }
            }
            if(commonIndex < commonCount){
                commonCount = commonIndex
            }
            if(commonCount == 0){
                break
            }
        }
        return if(commonCount == 0){
            ""
        }else {
            val text = res.subList(0, commonCount).toCharArray()
            String(text)
        }
    }
}