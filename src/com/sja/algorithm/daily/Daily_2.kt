package com.sja.algorithm.daily

import java.util.*

class Daily_2 : DailyAlgorithmExecutor {
    override fun getTitle(): String {
        return "删除字符串内的b和连续的ac"
    }

    override fun getDescription(): String {
        return "删除字符串内的b和连续的ac"
    }

    override fun execute() {
        println(delete("dfaaabbbcccdfdf"))
    }

    // aabccccac
    private fun delete(text: String): String {
        if (text.isEmpty()) {
            return ""
        }
        val stack = Stack<Char>()
        text.forEach {
            if(it == 'b'){
                
            }else if(it == 'c'){
                if(stack.isEmpty()){
                    stack.push(it)
                }else{
                    if(stack.peek() == 'a'){
                        stack.pop()
                    }else{
                        stack.push(it)
                    }
                }
            }else{
                stack.push(it)
            }
        }
        var res = ""
        stack.forEach {
            res += it
        }
        return res
    }
}