package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode
import java.util.*

class LeetCode_61 : IAlgorithmExecutor {

    override fun execute() {
        val res = rotateRight(Consts.NODE_ONE_DIGIT_FIRST_4,2)
        println(res)
    }

    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k < 1) {
            return head
        }
        val stack = Stack<ListNode>()
        var h = head
        stack.push(h)
        while (h != null) {
            h = h.next
            if(h != null) {
                stack.push(h)
            }
        }
        val moveCount = k % stack.size
        if (moveCount == 0) {
            return head
        }
        var index = 0
        var hePre:ListNode? = null
        var he:ListNode? = null
        var tail:ListNode? = null
        while (index <= moveCount) {
            val top = stack.pop()
            if(tail == null){
                tail = top
            }
            if(index != moveCount){
                he = top
            }
            hePre = top
            index++
        }
        tail?.next = head
        hePre?.next = null
        return he
    }
}