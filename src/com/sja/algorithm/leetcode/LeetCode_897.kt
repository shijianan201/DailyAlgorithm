package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode
import java.util.*

class LeetCode_897 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun increasingBST(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val stack = Stack<TreeNode>()
        val orderStack = Stack<TreeNode>()
        var cur = root
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
            if(!stack.isEmpty()){
                val top = stack.pop()
                orderStack.push(top)
                cur = top.right
            }
        }
        var res: TreeNode? = null
        for (i in 0 until orderStack.size) {
            val top = orderStack.pop()
            top.left = null
            top.right = res
            res = top
        }
        return res
    }
}