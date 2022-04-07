package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*
import kotlin.collections.HashSet

class LeetCode_954 : IAlgorithmExecutor {

    override fun execute() {
        val res = canReorderDoubled(intArrayOf(2,1,2,1,1,1,2,2))
        println(res)
    }

    //-4 -2 2 4
    fun canReorderDoubled(arr: IntArray): Boolean {
        if(arr.size == 0){
            return true
        }
        Arrays.sort(arr)
        val connectSet = HashSet<Int>()
        var pos = 0
        while (pos < arr.size) {
            if (connectSet.size % 2 != 0) {
                break
            }
            if (connectSet.contains(pos)) {
                pos++
                continue
            }
            val pre = arr[pos]
            connectSet.add(pos)
            for (i in (pos + 1) until arr.size) {
                if (connectSet.contains(i)) {
                    continue
                }
                val cur = arr[i]
                if (pre < 0) {
                    if (cur * 2 == pre) {
                        connectSet.add(i)
                        break
                    }
                } else {
                    if (cur == pre * 2) {
                        connectSet.add(i)
                        break
                    }
                }
            }
            pos++
        }
        return connectSet.size == arr.size
    }
}