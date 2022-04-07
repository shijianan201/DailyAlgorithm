package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_720 : IAlgorithmExecutor {

    override fun execute() {
        val res = longestWord(arrayOf("a", "banana", "app", "appl", "ap", "apply", "apple"))
        println(res)
    }

    fun longestWord(words: Array<String>): String {
        if (words.isEmpty()) {
            return ""
        }
        if (words.size == 1) {
            return words[0]
        }
        val hashMap = hashMapOf<Int, HashSet<String>>()
        for (word in words) {
            val len = word.length
            hashMap.put(len, hashMap.getOrDefault(len, hashSetOf(word)).apply {
                add(word)
            })
        }
        if (hashMap.get(1).isNullOrEmpty()) {
            return ""
        }
        val result = hashMap.get(1)?: hashSetOf()
        get(2, hashMap, result)
        if (result.isEmpty()) {
            return ""
        }
        var index = Int.MAX_VALUE
        result.forEach {
            val i = words.indexOfFirst { word ->
                word == it
            }
            if (i < index) {
                index = i
            }
        }
        return words[index]
    }

    private fun get(currentIndex: Int, hashMap: HashMap<Int, HashSet<String>>, res: HashSet<String>) {
        if (hashMap.isEmpty() || currentIndex > hashMap.size || res.isEmpty()) {
            return
        }
        val highSet = hashMap.get(currentIndex)
        if (highSet.isNullOrEmpty()) {
            return
        }
        val result = hashSetOf<String>()
        highSet.forEach { high ->
            val low = res.firstOrNull {
                high.startsWith(it)
            }
            low?.let {
                result.add(high)
            }
        }
        if(result.isEmpty()){
            return
        }
        res.clear()
        res.addAll(result)
        get(currentIndex + 1, hashMap, res)
    }
}