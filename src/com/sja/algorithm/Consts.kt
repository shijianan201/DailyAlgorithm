package com.sja.algorithm

import com.sja.algorithm.model.ListNode

object Consts {
    val INT_ARRAY_NOT_SORTED = intArrayOf(22, 33, 11, 35, 16, 5, 9, 10, 2, 19)
    val INT_ARRAY_NOT_SORTED_1 = intArrayOf(11, 35, 34, 51, 23)
    const val STRING_LEN_20 = "abcffbabdbiruriabcbacbb"
    val NODE_ONE_DIGIT_FIRST = ListNode(6)
    val NODE_ONE_DIGIT_FIRST_1 = ListNode(5, NODE_ONE_DIGIT_FIRST)
    val NODE_ONE_DIGIT_FIRST_2 = ListNode(4, NODE_ONE_DIGIT_FIRST_1)
    val NODE_ONE_DIGIT_FIRST_3 = ListNode(8, NODE_ONE_DIGIT_FIRST_2)

    val NODE_ONE_DIGIT_SECOND = ListNode(6)
    val NODE_ONE_DIGIT_SECOND_1 = ListNode(5, NODE_ONE_DIGIT_SECOND)
    val NODE_ONE_DIGIT_SECOND_2 = ListNode(4, NODE_ONE_DIGIT_SECOND_1)
    val NODE_ONE_DIGIT_SECOND_3 = ListNode(3, NODE_ONE_DIGIT_SECOND_2)
}