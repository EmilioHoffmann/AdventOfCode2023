package com.hoffmann.emilio.adventofcode2023.one

import android.content.Context
import com.hoffmann.emilio.adventofcode2023.R
import com.hoffmann.emilio.adventofcode2023.utils.getStringListFromFile

class One {
    companion object {

        fun main(context: Context) {
            val input = getStringListFromFile(R.raw.input_one, resources = context.resources)
            val sum = sumListOfStrings(input)
            println(sum)
        }

        fun sumListOfStrings(input: List<String>): Int {
            val filterNumberOnly = input.map { sumNumbersInline(it) }

            return filterNumberOnly.sum()
        }

        fun sumNumbersInline(string: String): Int {
            val allStringsAsNumbers = convertWrittenNumbersToActualNumbersWithoutRemoving(string)
            val filterNumberOnly = allStringsAsNumbers.replace("[^0-9]".toRegex(), "")

            val firstDigit = filterNumberOnly.first()
            val lastDigit = filterNumberOnly.last()
            return (firstDigit.toString() + lastDigit.toString()).toInt()
        }

        fun convertWrittenNumbersToActualNumbersWithoutRemoving(input: String): String {
            val writtenNumbers = mapOf(
                "zero" to "0",
                "one" to "1",
                "two" to "2",
                "three" to "3",
                "four" to "4",
                "five" to "5",
                "six" to "6",
                "seven" to "7",
                "eight" to "8",
                "nine" to "9"
            )

            val result = StringBuilder()

            var i = 0
            while (i < input.length) {
                var foundMatch = false
                for ((writtenNumber, actualNumber) in writtenNumbers) {
                    if (input.regionMatches(
                            i,
                            writtenNumber,
                            0,
                            writtenNumber.length,
                            ignoreCase = true
                        )
                    ) {
                        result.append(actualNumber)
                        foundMatch = true
                        break
                    }
                }
                if (!foundMatch) {
                    result.append(input[i])
                }
                i++
            }

            return result.filter { it.isDigit() }.toString()
        }
    }
}
