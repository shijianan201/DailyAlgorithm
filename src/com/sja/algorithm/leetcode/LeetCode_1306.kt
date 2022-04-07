package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_1306 : IAlgorithmExecutor {

    override fun execute() {
        val res = canReach(intArrayOf(4,2,3,0,3,1,2), 0)
        println(res)
    }

    fun canReach(arr: IntArray, start: Int): Boolean {
        if (arr.size == 1) {
            return true
        }
        val cacheSet = HashSet<Int>()
        return backTrack(arr, start,cacheSet)
    }

    fun backTrack(arr: IntArray, start: Int,visitedSet:HashSet<Int>): Boolean {
        if(visitedSet.contains(start)){
            return false
        }
        visitedSet.add(start)
        if (arr[start] == 0) {
            return true
        }
        val min = start - arr[start]
        val leftRes = if (min < 0) {
            false
        } else {
            backTrack(arr, min,visitedSet)
        }
        if (leftRes) {
            return true
        }
        val max = start + arr[start]
        val rightRes = if (max >= arr.size) {
            false
        } else {
            backTrack(arr, max,visitedSet)
        }
        return rightRes
    }
}