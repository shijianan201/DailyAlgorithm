package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode

class LeetCode_404 : IAlgorithmExecutor {

    override fun execute() {
        val res = sumOfLeftLeaves(Consts.TREE_BINARY_1)
        println(res)
    }

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if(root == null){
            return 0
        }
        if(root.left == null && root.right == null){
            return 0
        }
        return sum(root, false)
    }

    fun sum(root: TreeNode?, isLeft: Boolean): Int {
        if (root == null) {
            return 0
        }
        val res = if (root.left == null && root.right == null && isLeft) {
           root.`val`
        } else {
            0
        }
        return res + sum(root.left, true) + sum(root.right, false)
    }
}