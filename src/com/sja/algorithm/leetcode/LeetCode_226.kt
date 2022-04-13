package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode

class LeetCode_226 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun invertTree(root: TreeNode?): TreeNode? {
        if(root == null){
            return null
        }
        val temp = root.left
        root.left = root.right
        root.right = temp
        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}