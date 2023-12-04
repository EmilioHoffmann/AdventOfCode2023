package com.hoffmann.emilio.adventofcode2023.two

import android.content.Context
import com.hoffmann.emilio.adventofcode2023.R
import com.hoffmann.emilio.adventofcode2023.utils.getStringListFromFile

class Two {
    companion object {
        fun main(context: Context) {
            val input = getStringListFromFile(R.raw.input_two, resources = context.resources)
            val games = input.map { parseGame(it) }
//            val valid = games.filterNot { game ->
//                game.sets.any { set -> !set.isValidGame }
//            }
            val sum = games.sumOf { it.powerOfGame }
            println(sum)
        }

        data class Game(
            val id: Int,
            val sets: List<Set>,
            val powerOfGame: Int
        )

        data class Set(
            val red: Int = 0,
            val green: Int = 0,
            val blue: Int = 0,
            val isValidGame: Boolean
        )

        fun parseGame(string: String): Game {
            val (idString, setsString) = string.split(": ")
            val id = idString.trim().removePrefix("Game ").toInt()
            val sets = setsString.split("; ").map { parseSet(it) }
            val highestBlue = sets.maxOf { it.blue }
            val highestGreen = sets.maxOf { it.green }
            val highestRed = sets.maxOf { it.red }

            val powerOfGame = highestBlue * highestGreen * highestRed
            return Game(
                id,
                sets,
                powerOfGame
            )
        }

        fun parseSet(string: String): Set {
            val items = string.split(", ")
            var red = 0
            var green = 0
            var blue = 0
            var isValid = true
            for (item in items) {
                val (numberOfDies, color) = item.split(" ")
                when (color) {
                    "red" -> {
                        val x = numberOfDies.toIntOrNull() ?: 0
                        if (x > 12) {
                            isValid = false
                        }
                        red = x
                    }

                    "green" -> {
                        val x = numberOfDies.toIntOrNull() ?: 0
                        if (x > 13) {
                            isValid = false
                        }
                        green = x
                    }

                    "blue" -> {
                        val x = numberOfDies.toIntOrNull() ?: 0
                        if (x > 14) {
                            isValid = false
                        }
                        blue = x
                    }
                }
            }
            return Set(red, green, blue, isValid)
        }
    }
}