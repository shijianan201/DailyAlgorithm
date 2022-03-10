package com.sja.algorithm.daily

import com.sja.algorithm.IAlgorithmExecutor

interface DailyAlgorithmExecutor : IAlgorithmExecutor {

    fun getTitle(): String

    fun getDescription(): String

}