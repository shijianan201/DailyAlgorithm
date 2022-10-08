package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode

class LeetCode_206 : IAlgorithmExecutor {

    override fun execute() {
        val res = reverseListByRecursive(Consts.NODE_ONE_DIGIT_FIRST_4)
        println(res)
    }

    // 1-2-3-4-5
    fun reverseListByRecursive(head: ListNode?): ListNode? {
        return reverseListByRecursive(null, head)
    }

    fun reverseListByRecursive(pre: ListNode?, cur: ListNode?): ListNode? {
        if (cur == null) {
            return null
        }
        val next = cur.next
        cur.next = pre
        return if(next == null){
            cur
        }else {
            reverseListByRecursive(cur, next)
        }
    }

    fun reverseListByLoop(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        var pre: ListNode? = null
        var cur = head
        while (cur != null) {
            val next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        }
        return pre
    }


}