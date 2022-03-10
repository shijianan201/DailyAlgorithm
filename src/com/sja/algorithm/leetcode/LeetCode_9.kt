package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*

class LeetCode_9 : IAlgorithmExecutor {

    override fun execute() {
        val res = isPalindrome(1234)
        println(res)
    }

    fun isPalindrome(x: Int): Boolean {
        if(x < 0){
            return false
        }
        if(x < 10){
            return true
        }
        val stack = Stack<Int>()
        val queue = LinkedList<Int>()
        var res = x
        while (res > 0){
            val a = res % 10
            stack.push(a)
            queue.offer(a)
            res /= 10
        }
        while (stack.isNotEmpty()){
            if(stack.pop() != queue.poll()){
                return false
            }
        }
        return true
    }
}