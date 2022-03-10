package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_15 : IAlgorithmExecutor {

    override fun execute() {
        val res = threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
        println(res.joinToString(","))
    }

    /**
     * 回溯法解 超时
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return arrayListOf()
        }
        Arrays.sort(nums)
        val res = arrayListOf<ArrayList<Int>>()
        recursive(res, nums, arrayListOf(), 0, 0)
        return res
    }

    fun recursive(res: ArrayList<ArrayList<Int>>, nums: IntArray,
                  curArr: ArrayList<Int>,
                  position: Int, target: Int) {
        if (curArr.size == 3) {
            val sum = curArr.sum()
            if (sum == target) {
                res.add(ArrayList(curArr))
            }
            return
        }
        if(curArr.size > 3){
            return
        }
        val posArr = arrayListOf<Int>()
        for (i in position until nums.size) {
            if(posArr.contains(nums[i])){
                continue
            }
            posArr.add(nums[i])
            curArr.add(nums[i])
            recursive(res, nums, curArr,i + 1, target - nums[i])
            curArr.removeAt(curArr.size - 1)
        }
    }
}