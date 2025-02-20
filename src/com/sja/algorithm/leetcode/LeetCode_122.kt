package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_122 :IAlgorithmExecutor {

    override fun execute() {
    }

    //取上升波段解法
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0;
        var minValue = prices[0]
        for(i in 1 until prices.size){
            if(prices[i] >= minValue){
                maxProfit += prices[i]-minValue
                minValue = prices[i]
            }else{
                minValue = prices[i]
            }
        }
        return maxProfit
    }
}