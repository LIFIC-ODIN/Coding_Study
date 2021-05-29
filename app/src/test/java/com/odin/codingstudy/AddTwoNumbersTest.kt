package com.odin.codingstudy

import com.odin.codingstudy.leetcode.medium.AddTwoNumbers
import org.junit.Assert
import org.junit.Test

class AddTwoNumbersTest {
    @Test
    fun AddTwoNumbersArray() {
        val result = AddTwoNumbers.addTwoNumbers(INSERT1, INSERT2)
        Assert.assertEquals(RESULT, result)
    }

    companion object {
        private val INSERT1 = intArrayOf(2, 4, 3)
        private val INSERT2 = intArrayOf(5, 6, 4)
        private val RESULT = intArrayOf(7, 0, 8)
    }
}