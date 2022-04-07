package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_661 : IAlgorithmExecutor {

    override fun execute() {
        val res = imageSmoother(arrayOf(intArrayOf(100,200,100),intArrayOf(200,50,200),intArrayOf(100,200,100)))
        res.forEach {
            println(it.contentToString())
        }
    }

    fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
        val len = img.size
        val colLen = img[0].size
        val res = Array<IntArray>(len) {
            IntArray(colLen) {
                0
            }
        }
        for (row in 0 until len) {
            for (col in 0 until colLen) {
                var sumCount = 0
                var sumRes = 0
                for (i in row-1 until row + 2){
                    for (j in col-1 until col + 2){
                        if(i >= 0 && i < len && j >= 0 && j < colLen){
                            sumRes += img[i][j]
                            sumCount++
                        }
                    }
                }
                res[row][col] = sumRes / sumCount
            }
        }
        return res
    }
}