package com.odin.codingstudy.leetcode.easy

import java.lang.Exception

class TwoSum {

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    정수형 배열과 정수 target이 주어졌을때, 배열의 합이 target과 같은 경우의 index를 배열로 리턴
     * */

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>() as HashMap<Int, Int>
        nums.forEachIndexed { index, i ->
            if (map.containsKey(i)) {
                map[i]?.let {
                    return intArrayOf(it, index)
                }
            }
            map[target - i] = index
        }
        throw IllegalArgumentException("Fail")
    }

    fun anotherSolution(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[j] == target - nums[i]) {
                    return intArrayOf(i, j)
                }
            }
        }
        throw Exception("Fail")
    }

    fun anotherSolution1(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                map[complement]?.let {
                    return intArrayOf(it, i)
                }
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}