package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.TreeNode

class LeetCode_257 : IAlgorithmExecutor {

    override fun execute() {
        val paths = binaryTreePaths(Consts.TREE_BINARY_1)
    }

    fun binaryTreePaths(root: TreeNode?): List<String> {
        if(root == null){
            return arrayListOf()
        }
        val res = arrayListOf<String>()
        recursive(root,"",res)
        return res
    }

    fun recursive(root: TreeNode?,cur:String,res:ArrayList<String>){
        if(root == null){
            return
        }
        val text = if(cur.isEmpty()) "${root.`val`}" else (cur + "->${root.`val`}")
        if(root.left == null && root.right == null){
            res.add(text)
            return
        }
        recursive(root.left,text,res)
        recursive(root.right,text,res)
    }
}