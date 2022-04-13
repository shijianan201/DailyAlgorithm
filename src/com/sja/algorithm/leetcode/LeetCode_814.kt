package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode


class LeetCode_814 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun pruneTree(root: TreeNode?): TreeNode? {
        val res = pruneTree1(root)
        return if (res == null) {
            null
        } else {
            if (res.`val` == -1) {
                null
            } else {
                res
            }
        }
    }

    fun pruneTree1(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val left = pruneTree1(root.left)
        val right = pruneTree1(root.right)
        if (left != null && left.`val` < 0) {
            root.left = null
        }
        if (right != null && right.`val` < 0) {
            root.right = null
        }
        if (root.left == null && root.right == null && root.`val` == 0) {
            root.`val` = -1
        }
        return root
    }
}