package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_1305 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val arr1 = LinkedList<Int>()
        val arr2 = LinkedList<Int>()
        inOrder(root1,arr1)
        inOrder(root2,arr2)
        val res = arrayListOf<Int>()
        while (arr1.isNotEmpty() || arr2.isNotEmpty()) {
            val top1 = if (arr1.isNotEmpty()) arr1.peek() else null
            val top2 = if (arr2.isNotEmpty()) arr2.peek() else null
            if (top1 == null) {
                res.add(top2!!)
                arr2.poll()
                continue
            }
            if (top2 == null) {
                res.add(top1!!)
                arr1.poll()
                continue
            }
            if (top1 < top2) {
                res.add(arr1.poll())
            } else {
                res.add(arr2.poll())
            }
        }
        return res
    }

    fun inOrder(root: TreeNode?,res:LinkedList<Int>){
        if(root!=null){
            inOrder(root.left,res)
            res.offer(root.`val`)
            inOrder(root.right,res)
        }
    }

}