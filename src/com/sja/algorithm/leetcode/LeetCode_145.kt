package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode
import java.util.*

class LeetCode_145 : IAlgorithmExecutor {

    override fun execute() {
        val res = postorderTraversal(Consts.TREE_BINARY_1)
        println(res.joinToString(","))
    }

    fun postorderTraversal(root: TreeNode?): List<Int> {
        val res = arrayListOf<Int>()
        if (root == null) {
            return res
        }
        val stack = Stack<TreeNode>()
        var cur = root
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                res.add(cur.`val`)
                stack.push(cur)
                cur = cur.right
            }
            if(!stack.isEmpty()){
                val top = stack.pop()
                cur = top.left
            }
        }
        res.reverse()
        return res
    }
}