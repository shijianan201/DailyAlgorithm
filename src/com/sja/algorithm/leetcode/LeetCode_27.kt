package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_27 : IAlgorithmExecutor {

    override fun execute() {
        println("删除重复项前数组：${Consts.INT_ARRAY_SORTED_DUPLICATE.contentToString()}")
        val res = removeElement(Consts.INT_ARRAY_SORTED_DUPLICATE,3)
        println("删除重复项后数组：${Consts.INT_ARRAY_SORTED_DUPLICATE.contentToString()}，真实长度为$res")
    }
    //0,1,2,2,3,0,4
    //0，1，2，3
    fun removeElement(nums: IntArray, `val`: Int): Int {
        if(nums.isEmpty()){
            return 0
        }
        if(nums.size == 1){
            return if(nums[0] == `val`){
                0
            }else{
                nums.size
            }
        }
        var first = 0
        var second = 1
        while (second < nums.size){
            if(nums[first] == `val`){
                while (second < nums.size){
                    if(nums[second] != `val`){
                        nums[first] = nums[second]
                        nums[second] = `val`
                        first ++
                        second ++
                        break
                    }else{
                        second++
                    }
                }
            }else{
                first++
                second = first + 1
            }
        }
        return first
    }
}