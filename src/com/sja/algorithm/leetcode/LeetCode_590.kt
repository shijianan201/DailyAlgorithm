package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.Node
import java.util.*

class LeetCode_590 : IAlgorithmExecutor {

    override fun execute() {
        val res = postorderRecursive(Node(1, arrayListOf(
            Node(2, arrayListOf(Node(5),Node(6),Node(7))),
            Node(3, arrayListOf(Node(8))),
            Node(4, arrayListOf(Node(9),Node(10))),
            )))
        println(res.joinToString(","))
    }

    fun postorder(root: Node?): List<Int> {
        if(root == null){
            return arrayListOf()
        }
        val res = arrayListOf<Int>()
        val stack = Stack<Node>()
        stack.push(root)
        while (!stack.isEmpty()){
            val top = stack.pop()
            res.add(top.`val`)
            for (node in top.children){
                stack.push(node)
            }
        }
        Collections.reverse(res)
        return res
    }

    fun postorderRecursive(root: Node?): List<Int> {
        if(root == null){
            return arrayListOf()
        }
        val res = arrayListOf<Int>()
        for (node in root.children){
            res.addAll(postorderRecursive(node))
        }
        res.add(root.`val`)
        return res
    }
}