package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_824 : IAlgorithmExecutor {

    override fun execute() {
        val res = toGoatLatin("I")
        println(res)
    }

    //输入：sentence = "I speak Goat Latin"
    //输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
    fun toGoatLatin(sentence: String): String {
        val list = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        var res: String = ""
        var aCount = "a"
        var preIsSpace: Boolean = true
        var wordTopChar: Char? = null
        var index = 0
        while (index <= sentence.length) {
            if (index == sentence.length) {
                if (wordTopChar != null) {
                    res += wordTopChar
                }
                res += "ma"
                res += aCount
                break
            }
            val ch = sentence.get(index)
            if (ch == ' ') {
                if (wordTopChar != null) {
                    res += wordTopChar
                }
                res += "ma"
                res += aCount
                res += ch
                aCount += "a"
                preIsSpace = true
            } else {
                if (preIsSpace) {
                    if (list.contains(ch)) {
                        //首字母是元音字母
                        wordTopChar = null
                        res += ch
                    } else {
                        //首字母不是元音字母
                        wordTopChar = ch
                    }
                } else {
                    res += ch
                }
                preIsSpace = false
            }
            index++
        }
        return res
    }
}