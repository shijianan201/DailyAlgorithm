package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode

class LeetCode_92 : IAlgorithmExecutor {

    override fun execute() {
        val res = reverseBetween(Consts.NODE_ONE_DIGIT_FIRST_4,2,4)
        println(res)
    }

    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head?.next == null || left == right) {
            return head
        }
        val first = ListNode(0)
        first.next = head
        val diff = right - left
        var preHead: ListNode? = first
        var tailNext = head
        var fast = 1
        while (fast <= right) {
            if(fast != right) {
                tailNext = tailNext?.next
            }
            if (fast > diff + 1) {
                preHead = preHead?.next
            }
            fast++
        }
        val tail = tailNext?.next
        var reverseStart = preHead?.next
        tailNext?.next = null
        preHead?.next = null
        var reverseSecond = reverseStart?.next
        var reversePre:ListNode? = null
        var reverseTail:ListNode? = null
        while (reverseSecond != null) {
            val next = reverseSecond.next
            reverseSecond.next = reverseStart
            reverseStart?.next = reversePre
            if(reverseTail == null){
                reverseTail = reverseStart
            }
            reversePre = reverseStart
            reverseStart = reverseSecond
            reverseSecond = next
        }
        reverseTail?.next = tail
        preHead?.next = reverseStart
        return first.next
    }
}