package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_39 : IAlgorithmExecutor {

    override fun execute() {
        val res = combinationSum(intArrayOf(2,3,5,7),7)
        println(res.joinToString(","))
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(candidates)
        val res = arrayListOf<ArrayList<Int>>()
        recursive(res, arrayListOf(),candidates,0,target)
        return res
    }

    fun recursive(res: ArrayList<ArrayList<Int>>, curArr: ArrayList<Int>, candidates: IntArray, position: Int, target: Int) {
        if(target == 0){
            res.add(ArrayList(curArr))
            return
        }
        for (i in position until candidates.size){
            if(candidates[i] > target){
                break
            }
            curArr.add(candidates[i])
            recursive(res, curArr, candidates, i, target-candidates[i])
            curArr.removeAt(curArr.size-1)
        }
    }
}