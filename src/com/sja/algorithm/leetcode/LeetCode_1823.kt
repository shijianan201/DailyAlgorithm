package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_1823 : IAlgorithmExecutor {

    override fun execute() {
        val res = findTheWinner(5, 2)
        println(res)
    }

    fun findTheWinner(n: Int, k: Int): Int {
        if (k == 1 || n == 1) {
            return n
        }
        val list = arrayListOf<Int>()
        for (i in 1..n) {
            list.add(i)
        }
        beginGame(k, 0, list)
        return list.get(0)
    }

    // 2
    // 1 2 3 4 5
    fun beginGame(k: Int, startPos: Int, list: ArrayList<Int>) {
        if (list.size == 1) {
            return
        }
        val deletePos = startPos + k - 1
        if (deletePos < list.size) {
            list.removeAt(deletePos)
            beginGame(k, deletePos, list)
        } else {
            val newIndex = deletePos % list.size
            list.removeAt(newIndex)
            beginGame(k, newIndex, list)
        }
    }
}
