package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode

class LeetCode_725 : IAlgorithmExecutor {

    override fun execute() {
        val res = splitListToParts(Consts.NODE_ONE_DIGIT_FIRST_4,2)
        println(res.joinToString(","))
    }

    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        if (head == null) {
            return arrayOf()
        }
        if (k == 1) {
            return arrayOf(head)
        }
        var h = head
        var nodeCount = 0
        while (h != null) {
            nodeCount++
            h = h.next
        }
        //多少个部分
        val partCount = nodeCount / k
        //剩余多少
        val remain = nodeCount % k
        val countList = Array<Int>(partCount) {
            k
        }
        for (i in 0 until remain) {
            countList[i] = countList[i] + 1
        }
        val res = arrayOf<ListNode?>()
        var index = 0
        var hp = head
        for (cnt in countList) {
            val temp = ListNode(1)
            temp.next = hp
            var count = 0
            while (count < cnt && hp != null) {
                count++
                if(count == cnt){
                    val tmp = hp.next
                    hp.next = null
                    hp = tmp
                    break
                }
                hp = hp.next
            }
            res[index] = temp.next
            index++
        }
        return res
    }
}