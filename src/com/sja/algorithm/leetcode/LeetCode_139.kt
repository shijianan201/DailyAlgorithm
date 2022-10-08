package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_139 : IAlgorithmExecutor {

    override fun execute() {
        val res = wordBreak("applepenapple", arrayListOf("apple", "pen"))
        println(res)
    }

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val res = dfs(s, wordDict, "")
        return res
    }

    fun dfs(s: String, wordDict: List<String>, curStr: String): Boolean {
        if (curStr == s) {
            return true
        }
        if (curStr.length >= s.length || !s.startsWith(curStr)) {
            return false
        }
        var res = false
        val cache = hashSetOf<String>()
        for (str in wordDict) {
            if(cache.contains(str)){
                continue
            }
            if(curStr.length + str.length > s.length){
                continue
            }
            cache.add(str)
            res = res || dfs(s, wordDict, "$curStr$str")
        }
        return res
    }
}