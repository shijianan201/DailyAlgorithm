package com.sja.algorithm.model

class ListNode(val `val`: Int, var next: ListNode? = null) {

    override fun toString(): String {
        return if (next == null) {
            "$`val`"
        } else {
            "${`val`}->${next}"
        }
    }

}