package com.odin.codingstudy.leetcode.medium

object AddTwoNumbers {
    /**
     *  * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     *
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * 각 노드에는 한 자리의 정수가 있으며 각 자리의 숫자가 거꾸로 되어있다.
     * 따라서 l1, l2 를 순서대로 비교하면서 더해주고 10 이상인 경우 carry 를 다음 노드로 넘기면 됩니다.
     * */

    fun addTwoNumbers(l1: IntArray, l2: IntArray): Iterable<Int> {
        val result = mutableListOf<Int>()
        var remainder = 0
        for (i in 0 until l1.size.coerceAtLeast(l2.size)) {
            val sum = l1.getOrElse(i) { 0 } + l2.getOrElse(i) { 0 } + remainder
            remainder = if (sum >= 10) 1 else 0
            result += if (remainder == 1) sum - 10 else sum
        }
        if (remainder == 1) result.add(1)
        return result
    }

    private fun ListNode?.value() = this?.`val` ?: 0

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int = 0): ListNode? {
        if (l1 == null && l2 == null && carry == 0) return null
        val s = l1.value() + l2.value() + carry
        return ListNode(s % 10).apply {
            next = addTwoNumbers(l1?.next, l2?.next, s / 10)
        }
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) return l2
        if (l2 == null) return l1
        var prev = ListNode(0)
        val dummy = prev
        var l1Clone = l1
        var l2Clone = l2
        var carry = 0
        var sum: Int
        while (l1Clone != null || l2Clone != null || carry > 0) {
            sum = (l1Clone?.`val` ?: 0) + (l2Clone?.`val` ?: 0) + carry
            carry = sum / 10

            val current = ListNode(sum % 10)
            prev.next = current
            prev = current

            l1Clone = l1Clone?.next
            l2Clone = l2Clone?.next
        }

        return dummy.next
    }

}