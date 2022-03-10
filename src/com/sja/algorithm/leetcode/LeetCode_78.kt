package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_78 : IAlgorithmExecutor {

    override fun execute() {
        val res = subsets(intArrayOf(1,2,3))
        println(res.joinToString(","))
    }

    fun subsets(nums: IntArray): List<List<Int>> {
        if(nums.isEmpty()){
            return arrayListOf(emptyList())
        }
        val first = arrayListOf<Int>()
        val res = arrayListOf<ArrayList<Int>>()
        for(i in nums.indices){
            backTrack(res, arrayListOf(),nums,i+1,0)
        }
        res.add(0,first)
        return res
    }

    fun backTrack(res:ArrayList<ArrayList<Int>>,cur:ArrayList<Int>,nums: IntArray,curCount:Int,position:Int){
        if(cur.size == curCount){
            res.add(ArrayList(cur))
            return
        }
        for (i in position until nums.size){
            if(cur.contains(nums[i])){
                continue
            }
            cur.add(nums[i])
            backTrack(res, cur, nums, curCount, i+1)
            cur.removeAt(cur.size-1)
        }
    }

}