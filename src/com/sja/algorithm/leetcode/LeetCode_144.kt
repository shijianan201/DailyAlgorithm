package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode
import java.util.*

class LeetCode_144 : IAlgorithmExecutor {

    override fun execute() {
        val res = preorderTraversal(Consts.TREE_BINARY_1)
        println(res.joinToString(","))
    }

    fun preorderTraversal(root: TreeNode?): List<Int> {
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
                cur = cur.left
            }
            if(!stack.isEmpty()){
                val top = stack.pop()
                cur = top.right
            }
        }
        return res
    }
}