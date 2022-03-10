package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode

class LeetCode_21 : IAlgorithmExecutor {

    override fun execute() {
//        mergeTwoLists()
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1 == null){
            return list2
        }
        if(list2 == null){
            return list1
        }
        return if(list1.`val` <= list2.`val`) {
            val head = list1.next
            list1.next = mergeTwoLists(head, list2)
            list1
        }else{
            val head = list2.next
            list2.next = mergeTwoLists(head, list1)
            list2
        }
    }
}