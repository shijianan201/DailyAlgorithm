package com.sja.algorithm.leetcode

import com.sja.algorithm.Consts
import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_917 : IAlgorithmExecutor {

    override fun execute() {
        val res = reverseOnlyLetters(Consts.TEXT_LETTER)
        println(Consts.TEXT_LETTER)
        println(res)
    }

    private fun reverseOnlyLetters(s: String): String {
        if (s.isEmpty() || s.length == 1) {
            return s
        }
        var left = 0
        var right = s.length - 1
        val chArr = s.toCharArray()
        while (left<right){
            while (!isLetter(chArr[left])){
                left++
            }
            while(!isLetter(chArr[right])){
                right--
            }
            if(left >= right){
                break
            }
            val temp = chArr[left]
            chArr[left] = chArr[right]
            chArr[right] = temp
            left++
            right--
        }
        return String(chArr)
    }

    private fun isLetter(ch:Char):Boolean{
        return (ch in 'a'..'z') || (ch in 'A'..'Z')
    }
}