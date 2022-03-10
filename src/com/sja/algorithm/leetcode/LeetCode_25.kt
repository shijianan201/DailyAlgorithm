package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode

class LeetCode_25 : IAlgorithmExecutor {

    override fun execute() {
        val res = reverseKGroup(Consts.NODE_ONE_DIGIT_FIRST_3,3)
        println(res)
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k <= 1) {
            return head
        }
        var loopCount = 1
        val first = head
        var tail = first
        while (loopCount < k) {
            tail = tail?.next
            if (tail == null) {
                return first
            }
            loopCount++
        }
        val next = tail?.next
        tail?.next = null
        val nextReverse = reverseKGroup(next, k)
        var tempFirst = first
        var second = tempFirst.next
        while (second != null) {
            val third = second.next
            second.next = tempFirst
            tempFirst = second
            second = third
        }
        first.next = nextReverse
        return tail
    }
}