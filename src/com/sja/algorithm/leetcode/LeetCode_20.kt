package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*

class LeetCode_20 : IAlgorithmExecutor {

    override fun execute() {
        val res = isValid("([}}])")
        println(res)
    }

    fun isValid(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        if (s.length % 2 != 0) {
            return false
        }
        val stack = Stack<Char>()
        val chArr = s.toCharArray()
        var i = 0
        while (i < chArr.size) {
            val ch = chArr[i]
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch)
            }else{
                if(stack.isEmpty()){
                    return false
                }
                val top =  stack.peek()
                if(ch == ')'){
                    if(top == '('){
                        stack.pop()
                    }else{
                        return false
                    }
                }
                if(ch == '}'){
                    if(top == '{'){
                        stack.pop()
                    }else{
                        return false
                    }
                }
                if(ch == ']'){
                    if(top == '['){
                        stack.pop()
                    }else{
                        return false
                    }
                }
            }
            i++
        }
        return stack.isEmpty()
    }
}