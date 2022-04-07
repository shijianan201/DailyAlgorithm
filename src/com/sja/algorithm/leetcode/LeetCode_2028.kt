package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_2028 : IAlgorithmExecutor {

    override fun execute() {
        val res = missingRolls(
            intArrayOf(
                4,
                5,
                6,
                2,
                3,
                6,
                5,
                4,
                6,
                4,
                5,
                1,
                6,
                3,
                1,
                4,
                5,
                5,
                3,
                2,
                3,
                5,
                3,
                2,
                1,
                5,
                4,
                3,
                5,
                1,
                5
            ), 4, 40
        )
        println(res.contentToString())
    }

    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val countSize = rolls.size + n
        val countNum = countSize * mean
        var remainNum = countNum - rolls.sum()
        if (remainNum > 6 * n || remainNum < n) {
            //超出n * 6 或者小于 n * 1说明没有此数组
            return intArrayOf()
        }
        val res = IntArray(n)
        var i = 0
        while (remainNum > 0) {
            res[i % n]++
            i++
            remainNum--
        }
        return res
    }

    fun backTrack(resList: ArrayList<ArrayList<Int>>, res: ArrayList<Int>, n: Int, remainNum: Int) {
        if (n < 0 || remainNum < 0 || n * 6 < remainNum || remainNum < n) {
            return
        }
        if (n == 0 && remainNum == 0) {
            resList.add(ArrayList(res))
            return
        }
        for (i in 1..6) {
            if (i > remainNum) {
                break
            }
            res.add(i)
            println("$i $n $remainNum 结果：${res.joinToString(",")}")
            backTrack(resList, res, n - 1, remainNum - i)
            res.removeAt(res.size - 1)
        }
    }
}