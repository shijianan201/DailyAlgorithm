package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*

class LeetCode_32 : IAlgorithmExecutor {

    override fun execute() {
        val res = longestValidParentheses("()()((())")
    }

    fun longestValidParentheses(s: String): Int {
        if(s.isEmpty()){
            return 0
        }
        var max = 0
        val stack = Stack<Int>()
        stack.push(-1)
        s.forEachIndexed { index, c ->
            if(c == '('){
                stack.push(index)
            }else{
                stack.pop()
                if(stack.isEmpty()){
                    stack.push(index)
                }else{
                    max = Math.max(max,index - stack.peek())
                }
            }
        }
        return max
    }
}