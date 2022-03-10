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

fun IntArray.toListNode():ListNode?{
    val pre = ListNode(1)
    var head:ListNode? = pre
    this.forEach {
        head?.next = ListNode(it)
        head = head?.next
    }
    return pre.next
}