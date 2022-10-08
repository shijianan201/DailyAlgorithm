package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_883 : IAlgorithmExecutor {

    override fun execute() {
        val res = projectionArea(arrayOf(intArrayOf(1, 0), intArrayOf(0, 2)))
        println(res)
    }

    fun projectionArea(grid: Array<IntArray>): Int {
        var topCount = 0//顶部
        var faceCount = 0//正面
        var sideCount = 0//侧边
        val map = hashMapOf<Int, Int>()
        grid.forEachIndexed { row, ints ->
            var maxFace = Int.MIN_VALUE
            ints.forEachIndexed { column, y ->
                if (y > 0) {
                    topCount++
                }
                if (y > maxFace) {
                    maxFace = y
                }
                val cacheY = map.get(column) ?: Int.MIN_VALUE
                if (y > cacheY) {
                    map.put(column, y)
                }
            }
            faceCount += maxFace
        }
        map.forEach {
            sideCount += it.value
        }
        return topCount + faceCount + sideCount
    }
}