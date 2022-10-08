package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode

class LeetCode_83 : IAlgorithmExecutor {

    override fun execute() {
    }

    //1->1->2->2->3
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        var start = head
        var end = head.next
        while (end != null){
            if(end.`val` == start?.`val`){
                //相同
                val next = end.next
                start.next = next
                end.next = null
                end = next
            }else{
                start = end
                end = end.next
            }
        }
        return head
    }
}