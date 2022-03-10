package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode

class LeetCode_24 : IAlgorithmExecutor {

    override fun execute() {
        swapPairs(Consts.NODE_ONE_DIGIT_FIRST)
    }

    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val second = head.next
        head.next = swapPairs(second?.next)
        second?.next = head
        return second
    }
}