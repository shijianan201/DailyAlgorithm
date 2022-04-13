package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode

class LeetCode_112 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }
        if(root.left == null && root.right == null){
            return targetSum == root.`val`
        }
        return hasPathSum(root.left, targetSum - root.`val`) ||  hasPathSum(root.right, targetSum - root.`val`)
    }
}