package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode
import java.util.*

class LeetCode_114 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }
        val stack = Stack<TreeNode>()
        val orderQueue = Stack<TreeNode>()
        var cur = root
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                orderQueue.push(cur)
                stack.push(cur)
                cur = cur.left
            }
            if (!stack.isEmpty()) {
                val top = stack.pop()
                cur = top.right
            }
        }
        var res: TreeNode? = null
        for (i in 0 until orderQueue.size) {
            val top = orderQueue.pop()
            top.left = null
            top.right = res
            res = top
        }
    }
}