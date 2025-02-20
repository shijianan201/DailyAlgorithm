package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_189 : IAlgorithmExecutor {
    override fun execute() {
    }

    //使用辅助数组，O(n),O(n)
    fun rotate(nums: IntArray, k: Int): Unit {
        if(k == 0){
            return
        }
        val realK = k % nums.size
        val list = arrayListOf<Int>()
        val start = nums.size - realK;
        for(i in start until nums.size){
            list.add(nums[i])
        }
        for(i in 0 until nums.size-realK){
            list.add(nums[i])
        }
        for(i in 0 until  nums.size){
            nums[i] = list.get(i);
        }
    }

    //使用翻转，O(n),O(1)
    fun rotate1(nums: IntArray, k: Int): Unit {
        val realK = k % nums.size
        reverse(nums,0,nums.size - 1)
        reverse(nums,0,realK - 1)
        reverse(nums,realK,nums.size - 1)
    }

    fun reverse(nums: IntArray, start: Int,end:Int){
        var s = start
        var e = end
        while(s < e){
            var temp = nums[s]
            nums[s] = nums[e]
            nums[e] = temp
            s++
            e--
        }
    }
}