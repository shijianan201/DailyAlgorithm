package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode
import java.util.*

class LeetCode_101 : IAlgorithmExecutor {

    override fun execute() {
        val res = isSymmetric(Consts.TREE_BINARY_1)
        println(res)
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return isSymmetric(root.left, root.right)
    }

    fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null) {
            return right == null
        }
        if (right == null) {
            return false
        }
        val isSame = left.`val` == right.`val`
        if (!isSame) {
            return false
        }
        val leftIsSame = isSymmetric(left.left, right.right)
        if (!leftIsSame) {
            return false
        }
        return isSymmetric(left.right, right.left)
    }
}