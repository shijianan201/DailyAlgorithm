package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import com.sja.algorithm.model.Node
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_429 : IAlgorithmExecutor {

    override fun execute() {
    }

    fun levelOrder(root: Node?): List<List<Int>> {
        if (root == null) {
            return arrayListOf()
        }
        val res = ArrayList<ArrayList<Int>>()
        val queue = LinkedList<Node>()
        queue.offer(root)
        while (!queue.isEmpty()) {
            val queueSize = queue.size
            val list = ArrayList<Int>()
            for (i in 0 until queueSize){
                val top = queue.poll()
                list.add(top.`val`)
                for (child in top.children){
                    queue.offer(child)
                }
            }
            res.add(list)
        }
        return res
    }

    fun levelOrder1(root: Node?): List<List<Int>> {
        if (root == null) {
            return arrayListOf()
        }
        val res = ArrayList<ArrayList<Int>>()
        val temp = ArrayList<Int>()
        val queue = LinkedList<Node>()
        queue.offer(root)
        var preCount = 1
        var curCount = 0
        while (!queue.isEmpty()) {
            val top = queue.poll()
            temp.add(top.`val`)
            preCount--
            for (child in top.children) {
                queue.offer(child)
                curCount++
            }
            if (preCount == 0) {
                //新的一层
                res.add(ArrayList(temp))
                temp.clear()
                preCount = curCount
                curCount = 0
            }
        }
        return res
    }
}