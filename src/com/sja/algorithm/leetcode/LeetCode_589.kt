package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.Node
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_589 : IAlgorithmExecutor {

    override fun execute() {
        val res = preorderByLoop(Node(1, arrayListOf(Node(2, arrayListOf(Node(5), Node(6), Node(7))), Node(3), Node(4))))
        println(res)
    }

    fun preorderByLoop(root: Node?): List<Int> {
        if (root == null) {
            return arrayListOf()
        }
        val res = arrayListOf<Int>()
        val stack = Stack<Node>()
        stack.push(root)
        while (!stack.isEmpty()){
            val top = stack.pop()
            res.add(top.`val`)
            for(i in top.children.size-1 downTo 0){
                stack.push(top.children[i])
            }
        }
        return res
    }

    fun preorder(root: Node?): List<Int> {
        if (root == null) {
            return arrayListOf()
        }
        val res = arrayListOf<Int>()
        backTrack(res,root)
        return res
    }

    fun backTrack(res:ArrayList<Int>,root: Node?){
        if(root == null){
            return
        }
        res.add(root.`val`)
        for (node in root.children){
            backTrack(res,node)
        }
    }

}