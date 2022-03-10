package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_46 : IAlgorithmExecutor {

    override fun execute() {
        val res = permute(intArrayOf(1,2,3))
        println(res.joinToString(","))
    }

    fun permute(nums: IntArray): List<List<Int>> {
        if(nums.isEmpty()){
            return arrayListOf()
        }
        val res = arrayListOf<ArrayList<Int>>()
        recursive(res, arrayListOf(),nums,0)
        return res
    }

    fun recursive(res:ArrayList<ArrayList<Int>>,curArr:ArrayList<Int>,nums: IntArray,position:Int){
        if(curArr.size == nums.size){
            res.add(ArrayList(curArr))
            return
        }
        for (i in position until nums.size){
            if(curArr.contains(nums[i])){
                continue
            }
            curArr.add(nums[i])
            recursive(res, curArr, nums, position)
            curArr.removeAt(curArr.size-1)
        }
    }
}