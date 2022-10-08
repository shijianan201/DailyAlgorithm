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
        return true
    }

}