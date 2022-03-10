package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import java.util.*

class LeetCode_26 : IAlgorithmExecutor {

    override fun execute() {
        println("删除重复项前数组：${Consts.INT_ARRAY_SORTED_DUPLICATE.contentToString()}")
        val res = removeDuplicates(Consts.INT_ARRAY_SORTED_DUPLICATE)
        println("删除重复项后数组：${Consts.INT_ARRAY_SORTED_DUPLICATE.contentToString()}，真实长度为$res")
    }

    fun removeDuplicates(nums: IntArray): Int {
        if(nums.size <= 1){
            return nums.size
        }
        var first = 0
        var second = 1
        while (second < nums.size){
            if(nums[second] == nums[first]){
                second++
            }else{
                if(second - first > 1){
                    nums[++first] = nums[second]
                }else{
                    second++
                    first++
                }
            }
        }
        return first + 1
    }
}