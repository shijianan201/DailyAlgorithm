package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode

class LeetCode_98 : IAlgorithmExecutor {

    override fun execute() {
        val res = isValidBST(Consts.TREE_BINARY_1)
        println(res)
    }

    fun isValidBST(root: TreeNode?): Boolean {
        if(root == null){
            return true
        }
        val left = root.left
        val right = root.right
        val leftRes = if(left == null) true else left.`val` <= root.`val`
        val rightRes = if(right == null) true else right.`val` >= root.`val`
        if(!leftRes || !rightRes){
            return false
        }
        return leftRes && rightRes && isValidBST(root.left) && isValidBST(root.right)
    }
}