package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode
import com.sja.algorithm.model.toListNode

class LeetCode_82 : IAlgorithmExecutor {

    override fun execute() {
        val res = deleteDuplicates(Consts.INT_ARRAY_SORTED_DUPLICATE.toListNode())
        println(res)
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val preHead = ListNode(head.`val` - 1)
        preHead.next = head
        var preNotDuplicate:ListNode? = preHead
        var currentStart:ListNode? = head
        var current = head.next
        var sameCount = if(head.`val` == head.next?.`val`) 1 else 0
        while (currentStart != null) {
            if (current?.`val` != currentStart?.`val`) {
                if(sameCount > 0){
                    currentStart = current
                }else{
                    preNotDuplicate?.next = currentStart
                    preNotDuplicate = currentStart
                    currentStart = current
                }
                current = current?.next
                sameCount = 0
            } else {
                sameCount++
                current = current.next
            }
        }
        currentStart?.next  = current
        preNotDuplicate?.next = currentStart
        return preHead.next
    }

    fun deleteDuplicatesSimple(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val preHead = ListNode(head.`val` - 1)
        preHead.next = head
        var preNotDuplicate = preHead
        var current = head
        while (current != null) {
            if (current.`val` != preNotDuplicate.`val`) {
                preNotDuplicate.next = current
                preNotDuplicate = current
                current = current.next
            } else {
                current = current.next
            }
        }
        preNotDuplicate.next = current
        return preHead.next
    }
}