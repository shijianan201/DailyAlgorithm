package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor
import java.util.*
import kotlin.collections.ArrayList

class LeetCode_937 : IAlgorithmExecutor {

    override fun execute() {
        val res = reorderLogFiles(arrayOf("dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"))
        println(res.joinToString(","))
    }

    /**
     * 输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
     * 输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
     * 解释： 字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
     * 数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
     */
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val numberQueue = ArrayList<String>()//存储数字日志
        val letterSet = TreeSet<LetterLog>()//存储字母日志
        logs.forEach {
            val log = isLetterLog(it)
            if (log == null) {
                numberQueue.add(it)
            } else {
                //字母
                letterSet.add(log)
            }
        }
        val res = Array<String>(numberQueue.size + letterSet.size) {
            ""
        }
        letterSet.forEachIndexed { index, letterLog ->
            res[index] = "${letterLog.tag}${letterLog.tail}"
        }
        numberQueue.forEachIndexed { index, s ->
            res[letterSet.size + index] = s
        }
        return res
    }

    fun isLetterLog(text: String): LetterLog? {
        var firstSpaceIndex = -1
        for (i in text.indices) {
            val ch = text.get(i)
            if (ch == ' ') {
                firstSpaceIndex = i
            } else {
                if (firstSpaceIndex >= 0) {
                    //判断是不是数字
                    return if (isNumber(ch)) {
                        null
                    } else {
                        LetterLog(text.substring(0, i), text.substring(i))
                    }
                }
            }

        }
        return null
    }

    fun isNumber(ch: Char): Boolean {
        return ch in '0'..'9'
    }

    inner class LetterLog(val tag: String, val tail: String) : Comparable<LetterLog> {

        override fun compareTo(other: LetterLog): Int {
            val res = this.tail.compareTo(other.tail)
            if(res == 0){
                return this.tag.compareTo(other.tag)
            }
            return res
        }

    }
}