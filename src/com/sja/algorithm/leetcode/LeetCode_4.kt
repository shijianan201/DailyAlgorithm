package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.findCenterNum

class LeetCode_4 : IAlgorithmExecutor {

    override fun execute() {
        println(Consts.INT_ARRAY_SORTED.contentToString())
        println(Consts.INT_ARRAY_SORTED_1.contentToString())
        val res = method_1(Consts.INT_ARRAY_SORTED,Consts.INT_ARRAY_SORTED_1)
        println("中位数是：$res")
    }

    private fun method_1(nums1:IntArray, nums2:IntArray):Double {
        if(nums1.isEmpty()){
            return nums2.findCenterNum()?:0.0
        }
        if(nums2.isEmpty()){
            return nums1.findCenterNum()?:0.0
        }
        var combineIndex = 0
        val combineArr = IntArray(nums1.size + nums2.size)
        var arr1Index = 0
        var arr2Index = 0
        while(arr1Index < nums1.size || arr2Index < nums2.size){
            val arr1Val = if(arr1Index < nums1.size) nums1[arr1Index] else null
            val arr2Val = if(arr2Index < nums2.size) nums2[arr2Index] else null
            if(arr1Val == null){
                combineArr[combineIndex] = arr2Val!!
                arr2Index++
                combineIndex++
                continue
            }
            if(arr2Val == null){
                combineArr[combineIndex] = arr1Val!!
                arr1Index++
                combineIndex++
                continue
            }
            if(arr1Val <= arr2Val){
                combineArr[combineIndex] = arr1Val
                arr1Index++
            }else{
                combineArr[combineIndex] = arr2Val
                arr2Index++
            }
            combineIndex++
        }
        return combineArr.findCenterNum()?:0.0
    }


}