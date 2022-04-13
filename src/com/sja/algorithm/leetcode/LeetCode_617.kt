package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode

class LeetCode_617 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if(root1 == null){
            return root2
        }
        if(root2 == null){
            return root1
        }
        val newVal = root1.`val` + root2.`val`
        val left = mergeTrees(root1.left,root2.left)
        val right = mergeTrees(root1.right,root2.right)
        return TreeNode(newVal,left,right)
    }
}