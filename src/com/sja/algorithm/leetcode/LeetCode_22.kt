package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_22 : IAlgorithmExecutor {

    override fun execute() {
        val res = generateParenthesis(3)
        println(res.joinToString(","))
    }

    fun generateParenthesis(n: Int): List<String> {
        if (n <= 0) {
            return arrayListOf()
        }
        val res = arrayListOf<String>()
        recursive(res, arrayListOf(), 0,0, n)
        return res
    }

    fun recursive(res: ArrayList<String>, strList: ArrayList<Char>, leftCount:Int,rightCount:Int,max:Int) {
        if (strList.size == max * 2) {
            res.add(String(strList.toCharArray()))
            return
        }
        if(leftCount < max){
            strList.add('(')
            recursive(res,strList, leftCount+1, rightCount, max)
            strList.removeAt(strList.size-1)
        }
        if(rightCount < leftCount){
            strList.add(')')
            recursive(res,strList, leftCount, rightCount+1, max)
            strList.removeAt(strList.size-1)
        }
    }
}