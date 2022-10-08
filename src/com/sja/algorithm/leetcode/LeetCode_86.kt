package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode
import java.util.*

class LeetCode_86 : IAlgorithmExecutor {

    override fun execute() {
    }

    // -1 1 4 3 2 5 2
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head == null) {
            return null
        }
        var tempH = head
        val smallQueue = LinkedList<ListNode>()
        val bigQueue = LinkedList<ListNode>()
        while (tempH != null) {
            val value = tempH.`val`
            val next = tempH.next
            tempH.next = null
            if (value < x) {
                //小于
                smallQueue.offer(tempH)
            } else {
                //大于或等于
                bigQueue.offer(tempH)
            }
            tempH = next

        }
        val root = ListNode(-1)
        var tempRoot = root
        while (smallQueue.isNotEmpty()){
            val top = smallQueue.poll()
            tempRoot.next = top
            tempRoot = top
        }
        while (bigQueue.isNotEmpty()){
            val top = bigQueue.poll()
            tempRoot.next = top
            tempRoot = top
        }
        return root.next
    }
}