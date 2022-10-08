package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import kotlin.math.abs

class LeetCode_1184 : IAlgorithmExecutor {

    override fun execute() {
        val res = distanceBetweenBusStops(intArrayOf(1,2,3,4),0,3)
        println(res)
    }

    fun distanceBetweenBusStops(distance: IntArray, start: Int, destination: Int): Int {
        if (start == destination) {
            return 0
        }
        val left = Math.min(start, destination)
        val right = Math.max(start, destination)
        if(abs(destination-start) == 1){
            return distance[start]
        }
        var cntAll = 0
        var cntBetween = 0
        var index = 0
        for (num in distance) {
            if (index >= left && index < right) {
                cntBetween += num
            }
            cntAll += num
            index++
        }
        return Math.min(cntBetween, cntAll - cntBetween)
    }
}