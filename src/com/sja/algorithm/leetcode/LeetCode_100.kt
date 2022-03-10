package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode

class LeetCode_100 : IAlgorithmExecutor {

    override fun execute() {

    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null) {
            return q == null
        }
        if (q == null) {
            return false
        }
        val curSame = p.`val` == q.`val`
        if (!curSame) {
            return false
        }
        val leftSame = isSameTree(p.left, q.left)
        if (!leftSame) {
            return false
        }
        return isSameTree(p.right, q.right)
    }
}