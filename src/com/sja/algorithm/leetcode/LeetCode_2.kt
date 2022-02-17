package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode

//两数相加
class LeetCode_2 : IAlgorithmExecutor {

    override fun execute() {
        println("两数相加")
        println(Consts.NODE_ONE_DIGIT_FIRST_3)
        println(Consts.NODE_ONE_DIGIT_SECOND_3)
        println(add(Consts.NODE_ONE_DIGIT_FIRST_3, Consts.NODE_ONE_DIGIT_SECOND_3))
    }

    private fun add(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) {
            return l2
        }
        if (l2 == null) {
            return l1
        }
        var l1Move = l1
        var l2Move = l2
        var forwardValue = 0
        val res = ListNode(0)
        var move = res
        while (l1Move != null || l2Move != null || forwardValue == 1) {
            val l1Val = l1Move?.`val` ?: 0
            val l2Val = l2Move?.`val` ?: 0
            val sum = l1Val + l2Val + forwardValue
            val nodeVal = if (sum >= 10) {
                forwardValue = 1
                sum % 10
            } else {
                forwardValue = 0
                sum
            }
            val newNode = ListNode(nodeVal)
            move.next = newNode
            move = newNode
            l1Move = l1Move?.next
            l2Move = l2Move?.next
        }
        return res.next
    }

}