package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import java.util.*

class LeetCode_349:IAlgorithmExecutor {

    override fun execute() {
        println("求两个数组交集")
        val res = intersection_1(Consts.INT_ARRAY_NOT_SORTED_1,Consts.INT_ARRAY_NOT_SORTED)
        println("HashMap解法结果：${res.contentToString()}")
    }

    private fun intersection_1(arr1: IntArray, arr2: IntArray): IntArray? {
        println(arr1.contentToString())
        println(arr2.contentToString())
        val smallLenArr = if(arr1.size > arr2.size) arr2 else arr1
        val longLenArr = if(arr1.size > arr2.size) arr1 else arr2
        val cache = hashSetOf<Int>()
        for (i in smallLenArr) {
            cache.add(i);
        }
        val list: MutableList<Int> = ArrayList()
        for (i in longLenArr) {
            if (cache.contains(i)) {
                list.add(i)
            }
        }
        return list.toIntArray()
    }

}