package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode

class LeetCode_110 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun isBalanced(root: TreeNode?): Boolean {
        return getHeight(root) != -1
    }

    fun getHeight(root: TreeNode?):Int{
        if(root == null){
            return 0
        }
        val left = getHeight(root.left)
        if(left == -1){
            return -1
        }
        val right = getHeight(root.right)
        if(right == -1){
            return -1
        }
        if(Math.abs(left - right) > 1){
            return -1
        }
        return Math.max(left,right) + 1
    }

//    fun isBalanced(root: TreeNode?): Boolean {
//        if (root == null) {
//            return true
//        }
//        val left = getHeight(root.left)
//        val right = getHeight(root.right)
//        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right)
//    }
//
//    fun getHeight(root: TreeNode?): Int {
//        if (root == null) {
//            return 0
//        }
//        val leftHeight = getHeight(root.left)
//        val rightHeight = getHeight(root.right)
//        return 1 + Math.max(leftHeight, rightHeight)
//    }
}