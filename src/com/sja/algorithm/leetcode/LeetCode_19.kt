package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode
import java.util.*

/**
 * 栈
 * 双指针
 */
class LeetCode_19 : IAlgorithmExecutor {

    override fun execute() {
        val res = removeNthFromEnd(Consts.NODE_ONE_DIGIT_FIRST, 1)
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null || n < 1) {
            return head
        }
        val first = ListNode(0)
        first.next = head
        var h: ListNode? = first
        val stack = Stack<ListNode>()
        while (h != null) {
            stack.push(h)
            h = h.next
        }
        for (i in 0 until n) {
            stack.pop()
        }
        return if (stack.isEmpty()) {
            first.next
        } else {
            val top = stack.pop()
            top.next = top.next?.next
            first.next
        }
    }

}