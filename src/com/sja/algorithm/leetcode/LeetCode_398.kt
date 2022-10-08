package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_398 : IAlgorithmExecutor {

    override fun execute() {
        method_1()
    }

    private fun method_1() {

    }
}

class Solution(nums: IntArray) {

    private val map = hashMapOf<Int,ArrayList<Int>>()
    private val random:Random = Random()

    init {
        nums.forEachIndexed { index, i ->
            if(map.containsKey(i)){
                map.get(i)?.add(index)
            }else{
                map.put(i, arrayListOf(index))
            }
        }
    }

    fun pick(target: Int): Int {
        val set = map.get(target)
        if(set != null){
            return set.get(random.nextInt(set.size)-1)
        }
        return -1
    }

}