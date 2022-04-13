package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_113 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) {
            return arrayListOf()
        }
        val res = ArrayList<ArrayList<Int>>()
        dfs(res, arrayListOf(), root, targetSum, 0)
        return res
    }

    fun dfs(res: ArrayList<ArrayList<Int>>, cur: ArrayList<Int>, root: TreeNode?, targetSum: Int, curSum: Int) {
        if (root == null) {
            return
        }
        cur.add(root.`val`)
        if (root.left == null && root.right == null && curSum + root.`val` == targetSum) {
            res.add(ArrayList(cur))
        }
        dfs(res, cur, root.left, targetSum, curSum + root.`val`)
        dfs(res, cur, root.right, targetSum, curSum + root.`val`)
        cur.removeAt(cur.size - 1)
    }
}