package com.hoffmann.emilio.adventofcode2023.four

import android.content.Context
import com.hoffmann.emilio.adventofcode2023.R

class Four {

    companion object {
        fun main(context: Context) {
            val input =
                context.resources.openRawResource(R.raw.input_four).bufferedReader()
                    .readLines()
            val map = input.map { calculateMatchingNumbers(it) }

            val sum = map.sumOf { it.powerWinnings }
            val part2 = secondPart(map)
            println(part2)
        }

        fun calculateMatchingNumbers(string: String): Game {

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

            var count = if (matchingNumbers.isNotEmpty()) 1 else 0
            if (matchingNumbers.size > 1)
                for (i in matchingNumbers.indices - 1) {
                    count *= 2
                }

            println("Matching numbers: $matchingNumbers")

            val game = Game(
                winingNumbers = set1,
                gameNumbers = set2,
                winnings = matchingNumbers.size,
                powerWinnings = count
            )

            return game
        }

        fun secondPart(games: List<Game>): Int {
            val count = (0..games.size).associateWith { 1 }.toMutableMap()
            games.forEachIndexed { i, game ->
                (i + 1..i + game.winingNumbers.intersect(game.gameNumbers).count()).forEach {
                    count[it] = count[it]!! + count[i]!!
                }
            }

            return count.filter { e -> e.key < games.size }.values.sum()
        }

        data class Game(
            val winingNumbers: Set<Int>,
            val gameNumbers: Set<Int>,
            val winnings: Int,
            val powerWinnings: Int
        )
    }
}