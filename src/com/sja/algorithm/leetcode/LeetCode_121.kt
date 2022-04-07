package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import kotlin.math.max
import kotlin.math.min

class LeetCode_121 : IAlgorithmExecutor {

    override fun execute() {
        val res  = maxProfit(intArrayOf(7,1,5,3,4,6))
        println(res)
    }

    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) {
            return 0
        }
        val res = Array(prices.size) { Array(prices.size) { 0 } }
        for (i in prices.indices) {
            for (j in prices.indices) {
                if (j <= i) {
                    res[i][j] = 0
                } else {
                    val buySell = prices[j] - prices[i]
                    val notBuySell = res[i + 1][j]
                    val buyNotSell = res[i][j - 1]
                    val notBuyNotSell = res[i + 1][j - 1]
                    res[i][j] = max(buySell, max(notBuySell, max(buyNotSell, notBuyNotSell)))
                }
            }
        }
        return res[prices.size - 1][prices.size - 1]
    }
}