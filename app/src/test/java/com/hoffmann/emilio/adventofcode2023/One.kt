package com.hoffmann.emilio.adventofcode2023

import com.hoffmann.emilio.adventofcode2023.one.One
import org.junit.Assert
import org.junit.Test

class OneTest {

    @Test
    fun sum() {
//        "1abc2" = 12
//        "pqr3stu8vwx" = 38
//        "a1b2c3d4e5f" = 15
//        "treb7uchet" = 77

        val result = One.sumNumbersInline("1234")
        Assert.assertEquals(14, result)

        val result2 = One.sumNumbersInline("1abc2")
        Assert.assertEquals(12, result2)

        val result3 = One.sumNumbersInline("pqr3stu8vwx")
        Assert.assertEquals(38, result3)

        val result4 = One.sumNumbersInline("a1b2c3d4e5f")
        Assert.assertEquals(15, result4)

        val result5 = One.sumNumbersInline("treb7uchet")
        Assert.assertEquals(77, result5)

//        two1nine = 29
//        eightwothree = 83
//        abcone2threexyz = 13
//        xtwone3four = 24
//        4nineeightseven2 = 42
//        zoneight234 = 14
//        7pqrstsixteen = 76

        val result6 = One.sumNumbersInline("two1nine")
        Assert.assertEquals(29, result6)

        val result7 = One.sumNumbersInline("eightwothree")
        Assert.assertEquals(83, result7)

        val result8 = One.sumNumbersInline("abcone2threexyz")
        Assert.assertEquals(13, result8)

        val result9 = One.sumNumbersInline("xtwone3four")
        Assert.assertEquals(24, result9)

        val result10 = One.sumNumbersInline("4nineeightseven2")
        Assert.assertEquals(42, result10)

        val result11 = One.sumNumbersInline("zoneight234")
        Assert.assertEquals(14, result11)

        val result12 = One.sumNumbersInline("7pqrstsixteen")
        Assert.assertEquals(76, result12)
    }

    @Test
    fun testConvertWrittenNumbersToActualNumbersWithoutRemoving() {
        val result = One.convertWrittenNumbersToActualNumbersWithoutRemoving("eightwoThreeFour")
        Assert.assertEquals("8234", result)
    }

    @Test
    fun testSumListOfStrings() {
//        two1nine = 29
//        eightwothree = 83
//        abcone2threexyz = 13
//        xtwone3four = 24
//        4nineeightseven2 = 42
//        zoneight234 = 14
//        7pqrstsixteen = 76
        val input = listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen"
        )
        val result = One.sumListOfStrings(input)
        Assert.assertEquals(281, result)
    }
}