package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_322 : IAlgorithmExecutor {

    override fun execute() {
        val res = coinChange(intArrayOf(1, 2, 5), 11)
        println(res)
    }

//    fun coinChange1(coins: IntArray, amount: Int): Int {
//        if (amount <= 0) {
//            return 0
//        }
//        val res = intArrayOf(amount + 1)
//        res[0] = 0
//        for (i in 1 until amount) {
//            var min = Int.MAX_VALUE
//            for (j in coins){
//
//            }
//            res[i] = min
//        }
//    }

    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount <= 0) {
            return 0
        }
        val res = arrayListOf<ArrayList<Int>>()
        recursive(res, arrayListOf(), coins, 0, amount)
        println(res.joinToString(","))
        return res.size
    }

    fun recursive(res: ArrayList<ArrayList<Int>>, cur: ArrayList<Int>, coins: IntArray, position: Int, amount: Int) {
        if (amount == 0) {
            res.add(ArrayList(cur))
            return
        }
        for (i in position until coins.size) {
            if (coins[i] > amount) {
                continue
            }
            cur.add(coins[i])
            recursive(res, cur, coins, position, amount - coins[i])
            cur.removeAt(cur.size - 1)
        }
    }
}