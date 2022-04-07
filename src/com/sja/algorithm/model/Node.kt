package com.sja.algorithm.model

class Node(var `val`: Int,var children: List<Node?> = listOf()){

    override fun toString(): String {
        return if (children.isEmpty()) {
            "$`val`"
        } else {
            "${`val`}->${children.joinToString("->")}"
        }
    }

}