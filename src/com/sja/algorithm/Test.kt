package com.sja.algorithm

import com.sja.algorithm.daily.DailyAlgorithmExecutor
import java.lang.Exception
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

object Test {

    @JvmStatic
    fun main(args: Array<String>) {
        val algorithmList = arrayListOf<Algorithm>(
            Algorithm(1, "LeetCode", "com.sja.algorithm.leetcode.LeetCode_"),
            Algorithm(2, "Daily", "com.sja.algorithm.daily.Daily_"),
            Algorithm(3,"剑指offer","com.sja.algorithm.jzoffer.JzOffer_")
        )
        while (true) {
            println("支持的算法集编号如下：")
            algorithmList.forEach {
                println("${it.bookNo}：${it.bookName}")
            }
            print("请输入要执行的算法集编号（输入'q'并回车程序将会结束）：")
            val bookNoInput = readLine()
            if ("q" == bookNoInput) {
                println("程序已退出！！！")
                break
            }
            val bookNo = bookNoInput?.toIntOrNull()
            if (bookNo == null || bookNo <= 0) {
                println("非法输入，请输入正整数！！！")
                continue
            }
            val algorithm = algorithmList.firstOrNull {
                it.bookNo == bookNo
            }
            if (algorithm == null) {
                println("主人很懒，暂时还未建立此题集！！！")
                continue
            }
            print("请输入${algorithm.bookName}题目号码（输入'q'并回车程序将会结束）：")
            val a = readLine()
            if ("q" == a) {
                println("程序已退出！！！")
                break
            }
            val problemNum = a?.toIntOrNull()
            if (problemNum == null || problemNum <= 0) {
                println("非法输入，请输入正整数！！！")
                continue
            }
            val cls = try {
                Class.forName("${algorithm.bookPackagePath}$a")
            } catch (e: Exception) {
                null
            }
            if (cls == null) {
                println("主人很懒，暂时还未解答此题！！！")
                continue
            }
            println("开始求解${algorithm.bookName}第${a}题...")
            val executorObj = cls.newInstance()
            val obj = Proxy.newProxyInstance(
                javaClass.classLoader,
                arrayOf(IAlgorithmExecutor::class.java),
                TimeInvokeHandler(executorObj)
            ) as IAlgorithmExecutor
            obj.execute()
            println("----------------------漂亮的分割线-----------------------")
        }
    }

}

data class Algorithm(
    val bookNo: Int,
    val bookName: String,
    val bookPackagePath: String
)

class TimeInvokeHandler(private val obj: Any?) : InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        when (obj) {
            is DailyAlgorithmExecutor -> {
                println("算法标题：${obj.getTitle()}")
                println("算法描述：${obj.getDescription()}")
            }
            else -> {

            }
        }
        val beforeStamp = System.currentTimeMillis()
        val obj = method?.invoke(obj)
        val afterStamp = System.currentTimeMillis()
        println("算法耗时：${afterStamp - beforeStamp}毫秒")
        return obj
    }

}