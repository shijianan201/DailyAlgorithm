package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_102 : IAlgorithmExecutor {

    override fun execute() {
        val res  = levelOrder(Consts.TREE_BINARY_1)
        println(res.joinToString(","))
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = arrayListOf<List<Int>>()
        if (root == null) {
            return res
        }
        val cache = LinkedList<TreeNode>()
        cache.offer(root)
        var currentLevelSize = 1
        val currentList = arrayListOf<Int>()
        while (cache.isNotEmpty()) {
            val parent = cache.poll()
            currentList.add(parent.`val`)
            if (parent.left != null) {
                cache.offer(parent.left)
            }
            if (parent.right != null) {
                cache.offer(parent.right)
            }
            if(currentLevelSize == currentList.size){
                res.add(currentList.toList())
                currentList.clear()
                currentLevelSize = cache.size
            }
        }
        return res
    }
}