package com.sja.algorithm.daily

class Daily_1 : DailyAlgorithmExecutor {

    override fun getTitle(): String {
        return "买矿泉水问题"
    }

    override fun getDescription(): String {
        return "你有n元，一瓶汽水2元，两个汽水瓶换一瓶汽水，四个瓶盖换一瓶汽水，问最多喝几瓶？"
    }

    override fun execute() {
        val money = 50
        val res = method_1(money)
        println("${money}元钱可以购买${res}瓶矿泉水")
    }

    private fun method_1(money: Int): Int {
        val bottleCnt = money / 2
        return bottleCnt + recursive(bottleCnt, 0, 0)
    }

    private fun recursive(bottleCnt: Int, bottleBodyCnt: Int, capCnt: Int): Int {
        if (bottleCnt == 0 && bottleBodyCnt < 2 && capCnt < 4) {
            return 0
        }
        val bodyBuy = (bottleCnt + bottleBodyCnt) / 2
        val bodyRemain = (bottleCnt + bottleBodyCnt) % 2
        val capBuy = (bottleCnt + capCnt) / 4
        val capRemain = (bottleCnt + capCnt) % 4
        println("瓶身换了${bodyBuy}，瓶盖换了${capBuy}，剩余瓶身：${bodyRemain}，剩余瓶盖：${capRemain}")
        return bodyBuy + capBuy + recursive(bodyBuy + capBuy, bodyRemain, capRemain)
    }


}