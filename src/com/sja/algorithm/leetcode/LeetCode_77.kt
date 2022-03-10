package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_77 : IAlgorithmExecutor {

    override fun execute() {
        val res = combine(1,1)
        println(res.joinToString(","))
    }

    fun combine(n: Int, k: Int): List<List<Int>> {
        if (k <= 0 || k < 1) {
            return arrayListOf()
        }
        val res = arrayListOf<ArrayList<Int>>()
        backTrack(res, arrayListOf(),0,n,k)
        return res
    }

    fun backTrack(res: ArrayList<ArrayList<Int>>, cur: ArrayList<Int>, position: Int, n: Int, k: Int) {
        if (cur.size == k) {
            res.add(ArrayList(cur))
            return
        }
        for (i in position until n) {
            cur.add(i + 1)
            backTrack(res, cur, i + 1, n, k)
            cur.removeAt(cur.size - 1)
        }
    }
}