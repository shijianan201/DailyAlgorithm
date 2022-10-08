package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode
import com.sja.algorithm.model.TreeNode
import java.util.*

class LeetCode_2074 : IAlgorithmExecutor {

    override fun execute() {
        val res = reverseEvenLengthGroups(Consts.NODE_ONE_DIGIT_FIRST_4)
    }

    // 9 8 4 5
    fun reverseEvenLengthGroups(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val stack = LinkedList<ListNode>()
        var loopCnt = 1
        var th: ListNode? = head
        var pre:ListNode? = null
        while (th != null) {
            if (loopCnt % 2 == 0) {
                var cnt = 0
                while (th != null && cnt < loopCnt) {
                    stack.offer(th)
                    th = th.next
                    cnt++
                }
                val next = th
                var center:ListNode? = null
                for (i in 0 until stack.size){
                    val top = stack.poll()
                    if(i == 0){
                        top.next = next
                    }else {
                        top.next = center
                    }
                    center = top
                }
                pre?.next = center
                stack.clear()
            } else {
                var cnt = 0
                while (th != null && cnt < loopCnt) {
                    pre = th
                    th = th.next
                    cnt++
                }
            }
            loopCnt++
        }
        return head
    }
}