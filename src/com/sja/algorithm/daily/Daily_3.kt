package com.sja.algorithm.daily

import kotlin.math.abs
import kotlin.math.max

class Daily_3 : DailyAlgorithmExecutor {

    val tenMap = hashMapOf<Int, String>().apply {
        put(0, "零")
        put(1, "一")
        put(2, "二")
        put(3, "三")
        put(4, "四")
        put(5, "五")
        put(6, "六")
        put(7, "七")
        put(8, "八")
        put(9, "九")
        put(10, "十")
    }
    val posMap = hashMapOf<Int, String>().apply {
        put(1, "")
        put(10, "十")
        put(100, "百")
        put(1000, "千")
        put(10000, "万")
        put(100000000, "亿")
    }

    override fun getTitle(): String {
        return "整数转汉字"
    }

    override fun getDescription(): String {
        return "12345转换后变为一万二千三百四十五"
    }

    override fun execute() {
        while (true) {
            print("请输入要转换的整数，按q结束：")
            val input = readLine()
            if (input == "q" || input == "Q") {
                break
            }
            val number = input?.toIntOrNull() ?: 0
            println("${number}转换后为${transfer(number)}")
        }
    }

    fun resolveZero(remain: Int, maxNum: Int): String {
        return if (remain == 0) {
            ""
        } else if (remain < maxNum) {
            "零${transfer(remain)}"
        } else {
            transfer(remain)
        }
    }

    /**
     * 123450000
     */
    private fun transfer(num: Int): String {
        val number = abs(num)
        if (number >= 100000000) {
            val res = number / 100000000
            val remain = number % 100000000
            return "${transfer(res)}${posMap[100000000]}${resolveZero(remain, 10000000)}"
        } else if (number >= 10000) {
            val res = number / 10000
            val remain = number % 10000
            return "${transfer(res)}${posMap[10000]}${resolveZero(remain, 1000)}"
        } else if (number >= 1000) {
            val res = number / 1000
            val remain = number % 1000
            return "${transfer(res)}${posMap[1000]}${resolveZero(remain, 100)}"
        } else if (number >= 100) {
            val res = number / 100
            val remain = number % 100
            return "${transfer(res)}${posMap[100]}${resolveZero(remain, 10)}"
        } else if (number > 10) {
            val res = number / 10
            val remain = number % 10
            val zero = if (remain == 0) {
                ""
            } else {
                transfer(remain)
            }
            return "${transfer(res)}${posMap[10]}$zero"
        }else {
            return tenMap[number] ?: ""
        }
    }

}