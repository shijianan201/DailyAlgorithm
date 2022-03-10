package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode

class LeetCode_143 : IAlgorithmExecutor {

    override fun execute() {
//        method_1()
    }

    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) {
            return
        }
        var headP = head
        var centerP = head
        while (centerP?.next != null) {
            headP = headP?.next
            centerP = centerP.next
            if (centerP != null) {
                centerP = centerP.next
            }
        }
    }
}