package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*
import kotlin.math.sin

class LeetCode_846 : IAlgorithmExecutor {

    override fun execute() {
        val res = isNStraightHand1(intArrayOf(8,8,9,7,7,7,6,7,10,6), 2)
        println(res)
    }

    //1,2,2,3,5,6,7,8    3
    fun isNStraightHand1(hand: IntArray, groupSize: Int): Boolean {
        if (hand.isEmpty() || hand.size % groupSize != 0) {
            return false
        }
        if (groupSize == 1) {
            return true
        }
        Arrays.sort(hand)
        println(hand.joinToString(","))
        val selectedSet = hashSetOf<Int>()
        var index = 0
        var sameIndex: Int? = null
        var singleCount = 0
        var preNum: Int? = null
        while (index < hand.size) {
            if (selectedSet.contains(index)) {
                index++
                continue
            }
            val cur = hand[index]
            println("当前：${index}，上一次相同：$sameIndex，总量：$singleCount，上次数字$preNum，当前数字：$cur")
            if (preNum == null) {
                singleCount++
                preNum = cur
                selectedSet.add(index)
                index++
            } else {
                if (cur == preNum) {
                    //相同的数
                    if (sameIndex == null) {
                        sameIndex = index
                    }
                    index++
                } else {
                    //不相同
                    if (cur - preNum == 1) {
                        //连续的数
                        selectedSet.add(index)
                        singleCount++
                        if (singleCount == groupSize) {
                            //到了分割点，重置标记
                            preNum = null
                            singleCount = 0
                            if (sameIndex != null) {
                                index = sameIndex
                            } else {
                                index++
                            }
                            sameIndex = null
                        } else {
                            preNum = cur
                            index++
                        }
                    } else {
                        //不连续的数
                        return false
                    }
                }
            }
        }
        return selectedSet.size == hand.size
    }
}