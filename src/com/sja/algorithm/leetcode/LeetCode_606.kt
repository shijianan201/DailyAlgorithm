package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode

class LeetCode_606 : IAlgorithmExecutor {

    override fun execute() {
        val res = tree2str(Consts.TREE_BINARY_1)
        println(res)
    }

    fun tree2str(root: TreeNode?): String {
        if (root == null) {
            return ""
        }
        if (root.left == null && root.right == null) {
            return "${root.`val`}"
        }
        return if (root.right == null) {
            "${root.`val`}(${tree2str(root.left)})"
        }else{
            "${root.`val`}(${tree2str(root.left)})(${tree2str(root.right)})"
        }
    }

}