package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class LeetCode_653 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun findTarget(root: TreeNode?, k: Int): Boolean {
        if(root == null){
            return false
        }
        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        val hashSet = HashSet<Int>()
        while (!queue.isEmpty()){
            val top = queue.poll()
            if(hashSet.contains(k - top.`val`)){
                return true
            }
            hashSet.add(top.`val`)
            top.left?.let {
                queue.offer(it)
            }
            top.right?.let {
                queue.offer(it)
            }
        }
        return false
    }
}