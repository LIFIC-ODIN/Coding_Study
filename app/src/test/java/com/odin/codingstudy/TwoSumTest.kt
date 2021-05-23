package com.odin.codingstudy

import com.odin.codingstudy.leetcode.easy.TwoSum
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class TwoSumTest {

    @Test
    fun twoSum() {
        val result = TwoSum().twoSum(INSERT, TARGET)
//        val result = TwoSum().anotherSolution(INSERT, TARGET)
//        val result = TwoSum().anotherSolution1(INSERT, TARGET)
        assertArrayEquals(RESULT, result)
    }

    companion object {
        private val INSERT = intArrayOf(3, 2, 4)
        private const val TARGET = 6

        private val RESULT = intArrayOf(1, 2)
    }
}