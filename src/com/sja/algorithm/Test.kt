package com.sja.algorithm

import java.lang.Exception
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        while (true) {
            print("请输入LeetCode题目号码（输入'q'并回车程序将会结束）：")
            val a = readLine()
            val problemNum = a?.toIntOrNull()
            if (problemNum == null || problemNum <= 0) {
                println("非法输入，请输入正整数！！！")
                continue
            }
            if ("q" == a) {
                println("程序已退出！！！")
                break
            }
            val cls = try {
                Class.forName("com.sja.algorithm.leetcode.LeetCode_$a")
            } catch (e: Exception) {
                null
            }
            if (cls == null) {
                println("主人很懒，暂时还未解答此题！！！")
                continue
            }
            println("开始求解LeetCode第${a}题...")
            val executorObj = cls.newInstance()
            val obj = Proxy.newProxyInstance(javaClass.classLoader, arrayOf(IAlgorithmExecutor::class.java), TimeInvokeHandler(executorObj)) as IAlgorithmExecutor
            obj.execute()
            println("----------------------漂亮的分割线-----------------------")
        }
    }
}

class TimeInvokeHandler(private val obj: Any?) : InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        val beforeStamp = System.currentTimeMillis()
        val obj = method?.invoke(obj)
        val afterStamp = System.currentTimeMillis()
        println("算法耗时:${afterStamp - beforeStamp}")
        return obj
    }

}