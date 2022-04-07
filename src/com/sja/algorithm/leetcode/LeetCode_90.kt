package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_90 : IAlgorithmExecutor {

    override fun execute() {
        val res = subsetsWithDup(intArrayOf(1, 2, 2,2,3))
        println(res.joinToString(","))
    }

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) {
            return arrayListOf()
        }
        Arrays.sort(nums)
        val res = ArrayList<ArrayList<Int>>()
        res.add(arrayListOf())//空列表也算子集
        val cur = ArrayList<Int>()
        for (i in 1..nums.size) {
            backTrack(nums, res, 0, cur, i)
        }
        return res
    }

    // 1,2,2,3
    fun backTrack(nums: IntArray, res: ArrayList<ArrayList<Int>>, position: Int, cur: ArrayList<Int>, count: Int) {
        if (cur.size == count) {
            res.add(ArrayList(cur))
            return
        }
        var num:Int? = null
        for (i in position until nums.size) {
            if(num == nums[i]){
                continue
            }
            num = nums[i]
            cur.add(nums[i])
            backTrack(nums, res, i + 1, cur, count)
            cur.removeAt(cur.size - 1)
        }
    }
}