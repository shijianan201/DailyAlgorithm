package com.sja.algorithm.leetcode

import com.sja.algorithm.IAlgorithmExecutor

class LeetCode_273 : IAlgorithmExecutor {

    private val singleArr = arrayListOf("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine")
    private val belowTwenty = arrayListOf(
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen"
    )
    private val tenArr =
        arrayListOf("Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety")
    private val afterHundred = arrayListOf("", "Thousand", "Million", "Billion")

    override fun execute() {
        val res = numberToWords(1000)
        println(res)
    }

    fun numberToWords(num: Int): String {
        if (num == 0) {
            return "Zero"
        }
        if (num < 10) {
            return singleArr[num - 1]
        } else if (num < 20) {
            return belowTwenty[num - 10]
        } else if (num < 100) {
            val res = num / 10
            val remain = num % 10
            return if (remain == 0) {
                tenArr[res - 1]
            } else {
                tenArr[res - 1] + " " + singleArr[remain - 1]
            }
        } else if (num < 1000) {
            val res = num / 100
            val remain = num % 100
            return if (remain == 0) {
                numberToWords(res) + " Hundred"
            } else {
                numberToWords(res) + " Hundred " + numberToWords(remain)
            }
        } else {
            var sb = ""
            var res = num
            var remain = 0
            var index = 0
            while (res > 0) {
                remain = res % 1000
                sb = if (remain == 0) {
                    sb
                } else {
                    "${numberToWords(remain)} ${afterHundred[index]} $sb"
                }
                res /= 1000
                index++
            }
            return sb
        }
    }
}