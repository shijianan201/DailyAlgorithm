package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_682 : IAlgorithmExecutor {

    override fun execute() {
        val res = calPoints(arrayOf("5","2","C","D","+"))
        println(res)
    }

    fun calPoints(ops: Array<String>): Int {
        val resList = arrayListOf<Int>()
        var indexOfRes = 0
        for (i in 0 until ops.size){
            val opsI = ops[i]
            when(opsI){
                "C"->{
                    resList.removeAt(resList.size-1)
                    indexOfRes--
                }
                "D"->{
                    resList.add(resList[indexOfRes-1] * 2)
                    indexOfRes++
                }
                "+"->{
                    resList.add(resList[indexOfRes-1] + resList[indexOfRes-2])
                    indexOfRes++
                }
                else -> {
                    resList.add(opsI.toInt())
                    indexOfRes++
                }
            }
        }
        return resList.sum()
    }
}