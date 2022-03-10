package com.sja.algorithm

import com.sja.algorithm.model.ListNode
import com.sja.algorithm.model.TreeNode

object Consts {
    val INT_ARRAY_NOT_SORTED = intArrayOf(22, 33, 11, 35, 16, 5, 9, 10, 2, 19)
    val INT_ARRAY_NOT_SORTED_1 = intArrayOf(11, 35, 34, 51, 23)
    val INT_ARRAY_SORTED = intArrayOf(1,3,5,7,9,11)
    val INT_ARRAY_SORTED_1 = intArrayOf(2,4,6,8)
    val INT_ARRAY_SORTED_DUPLICATE = intArrayOf(1,2,2,3,3,3,4,4,5,6,7,7,8,9)
    const val STRING_LEN_20 = "abcffbabdbiruriabcbacbb"
    val NODE_ONE_DIGIT_FIRST = ListNode(6)
    val NODE_ONE_DIGIT_FIRST_1 = ListNode(5, NODE_ONE_DIGIT_FIRST)
    val NODE_ONE_DIGIT_FIRST_2 = ListNode(4, NODE_ONE_DIGIT_FIRST_1)
    val NODE_ONE_DIGIT_FIRST_3 = ListNode(8, NODE_ONE_DIGIT_FIRST_2)
    val NODE_ONE_DIGIT_FIRST_4 = ListNode(9, NODE_ONE_DIGIT_FIRST_3)

    val NODE_ONE_DIGIT_SECOND = ListNode(6)
    val NODE_ONE_DIGIT_SECOND_1 = ListNode(5, NODE_ONE_DIGIT_SECOND)
    val NODE_ONE_DIGIT_SECOND_2 = ListNode(4, NODE_ONE_DIGIT_SECOND_1)
    val NODE_ONE_DIGIT_SECOND_3 = ListNode(3, NODE_ONE_DIGIT_SECOND_2)

    val TEXT_LETTER = "Qedo1ct-eeLg=ntse-T!"

    val TREE_BINARY_9 = TreeNode(9)
    val TREE_BINARY_8 = TreeNode(8)
    val TREE_BINARY_7 = TreeNode(7,right = TREE_BINARY_9)
    val TREE_BINARY_6 = TreeNode(6, TREE_BINARY_8)
    val TREE_BINARY_5 = TreeNode(5)
    val TREE_BINARY_4 = TreeNode(4)
    val TREE_BINARY_3 = TreeNode(3, TREE_BINARY_6, TREE_BINARY_7)
    val TREE_BINARY_2 = TreeNode(2, TREE_BINARY_4, TREE_BINARY_5)
    val TREE_BINARY_1 = TreeNode(1, TREE_BINARY_2, TREE_BINARY_3)
}