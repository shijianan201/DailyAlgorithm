package com.sja.algorithm

fun IntArray.findCenterNum(): Double? {
    if (this.isEmpty()) {
        return null
    }
    val center = this.size.shr(1)
    return if (this.size % 2 == 0) {
        (this[center] + this[center - 1]).toDouble() / 2
    } else {
        this[center].toDouble()
    }
}