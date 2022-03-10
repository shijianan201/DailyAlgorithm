package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_518 : IAlgorithmExecutor {

    override fun execute() {
//        method_1()
    }

    fun change(amount: Int,coins: IntArray): Int {
        if (amount <= 0) {
            return 0
        }
        val res = arrayListOf<ArrayList<Int>>()
        recursive(res, arrayListOf(), coins, 0, amount)
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