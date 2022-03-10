package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_47 : IAlgorithmExecutor {

    override fun execute() {
        val res = permuteUnique(intArrayOf(1,1,3))
        println(res.joinToString(","))
    }

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        if(nums.isEmpty()){
            return arrayListOf()
        }
        Arrays.sort(nums)
        val res = arrayListOf<ArrayList<Int>>()
        recursive(res, arrayListOf(), arrayListOf(),nums,0)
        return res
    }

    fun recursive(res:ArrayList<ArrayList<Int>>,curArr:ArrayList<Int>,posArr:ArrayList<Int>,nums: IntArray,position:Int){
        if(curArr.size == nums.size){
            res.add(ArrayList(curArr))
            return
        }
        var preValue:Int? = null
        for (i in position until nums.size){
            if(posArr.contains(i) || preValue == nums[i]){
                continue
            }
            preValue = nums[i]
            curArr.add(nums[i])
            posArr.add(i)
            recursive(res, curArr,posArr, nums, 0)
            posArr.removeAt(posArr.size-1)
            curArr.removeAt(curArr.size-1)
        }
    }
}