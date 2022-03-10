package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_40 : IAlgorithmExecutor {

    override fun execute() {
        val res = combinationSum2(intArrayOf(10,1,2,7,6,1,5),8)
        println(res.joinToString(","))
    }

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(candidates)
        val res = arrayListOf<ArrayList<Int>>()
        recursive(res, arrayListOf(), candidates, 0, target)
        return res
    }

    fun recursive(
        res: ArrayList<ArrayList<Int>>,
        curArr: ArrayList<Int>,
        candidates: IntArray,
        position: Int,
        target: Int
    ) {
        if (target == 0) {
            res.add(ArrayList(curArr))
            return
        }
        if (position >= candidates.size) {
            return
        }
        var preValue: Int? = null
        for (i in position until candidates.size) {
            if (candidates[i] > target) {
                break
            }
            if (preValue == candidates[i]) {
                continue
            }
            preValue = candidates[i]
            curArr.add(candidates[i])
            recursive(res, curArr, candidates, i + 1, target - candidates[i])
            curArr.removeAt(curArr.size - 1)
        }
    }
}