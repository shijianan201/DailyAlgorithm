package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import kotlin.math.min

class LeetCode_599 : IAlgorithmExecutor {

    override fun execute() {
        val res = findRestaurant(
            arrayOf("Shogun", "Tapioca Express", "Burger King", "KFC"),
            arrayOf("KFC", "Shogun", "Burger King")
        )
        println(res.joinToString(","))
    }

    fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
        if (list1.isEmpty() || list2.isEmpty()) {
            return arrayOf()
        }
        val res = arrayListOf<String>()
        val map = hashMapOf<String, Int>()
        list1.forEachIndexed { index, obj ->
            map.put(obj, index)
        }
        var minSum = -1
        list2.forEachIndexed { index, s ->
            val a = map.get(s)
            if (a != null) {
                val sum = a + index
                if(minSum < 0 || sum == minSum){
                    res.add(s)
                    minSum = sum
                }else{
                    if(sum < minSum){
                        res.clear()
                        res.add(s)
                        minSum = sum
                    }
                }
            }
        }
        return res.toTypedArray()
    }
}