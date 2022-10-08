package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_819 : IAlgorithmExecutor {

    override fun execute() {
        val res = mostCommonWord("Bob", arrayOf())
        println(res)
    }

    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        if (paragraph.isEmpty()) {
            return ""
        }
        val newParagraph = "$paragraph."
        var maxCount = 0
        var res: String = ""
        val map = HashMap<String, Int>()
        var wordStart = 0
        var wordEnd = 0
        var index = 0
        var preIsLetter = false
        while (index < newParagraph.length) {
            val ch = newParagraph.get(index)
            if ((ch in 'a'..'z') || (ch in 'A'..'Z')) {
                //字母
                if (preIsLetter) {
                    wordEnd++
                } else {
                    wordStart = index
                    wordEnd = index
                }
                preIsLetter = true
            } else {
                //标点符号
                if (preIsLetter) {
                    //新单词
                    wordEnd = index
                    val newText = newParagraph.substring(wordStart, wordEnd).toLowerCase()
                    val newCount = (map.get(newText) ?: 0) + 1
                    map.put(newText, newCount)
                    if (newCount > maxCount && !banned.contains(newText)) {
                        maxCount = newCount
                        res = newText
                    }
                }
                preIsLetter = false
            }
            index++
        }
        return res
    }
}