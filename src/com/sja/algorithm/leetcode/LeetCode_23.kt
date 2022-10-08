package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.ListNode

class LeetCode_23 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }
        if(lists.size == 1){
            return lists[0]
        }
        val newList = ArrayList<ListNode?>()
        for (i in 0 until lists.size step 2){
            if(i == lists.size - 1){
                newList.add(lists.get(i))
            }else{
                newList.add(merge2lists(lists.get(i),lists.get(i+1)))
            }
        }
        return mergeKLists(newList.toTypedArray())
    }

    fun merge2lists(first: ListNode?, second: ListNode?): ListNode? {
        if (first == null) {
            return second
        }
        if (second == null) {
            return first
        }
        val firstNode: ListNode
        var firstNext: ListNode? = first
        var secondNext: ListNode? = second
        if (first.`val` < second.`val`) {
            firstNode = first
            firstNext = firstNode.next
        } else {
            firstNode = second
            secondNext = firstNode.next
        }
        firstNode.next = merge2lists(firstNext,secondNext)
        return firstNode
    }
}