package com.hoffmann.emilio.adventofcode2023.four

import android.content.Context
import com.hoffmann.emilio.adventofcode2023.R
import kotlin.math.pow

class Four {

    companion object {
        fun main(context: Context) {
            val input =
                context.resources.openRawResource(R.raw.input_four).bufferedReader()
                    .readLines()
            val map = input.map { calculateMatchingNumbers(it) }
            val sum = map.sum()
            println(sum)
        }

        fun calculateMatchingNumbers(string: String): Int {

            val dividerIndex = string.indexOf("|")

            // Extract the number strings before and after "|"
            val card1String =
                string.substring(string.indexOf(":") + 1, dividerIndex).trim().replace("  ", " ")
            val card2String = string.substring(dividerIndex + 1).trim().replace("  ", " ")

            // Convert the number strings to sets of integers
            val set1 = card1String.split(" ").map { it.toInt() }.toSet()
            val set2 = card2String.split(" ").map { it.toInt() }.toSet()

            // Find the matching numbers
            val matchingNumbers = set1.intersect(set2)

            // Count the number of matching numbers

            var count = if (matchingNumbers.size > 0) 1 else 0
            if (matchingNumbers.size > 1)
                for (i in matchingNumbers.indices - 1) {
                    count *= 2
                }

            println("Matching numbers: $matchingNumbers")

            return count
        }
    }
}