package com.hoffmann.emilio.adventofcode2023

import com.hoffmann.emilio.adventofcode2023.one.One
import com.hoffmann.emilio.adventofcode2023.two.Two
import org.junit.Assert
import org.junit.Test

class TwoTest {

    @Test
    fun sum() {
//        Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
//        Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
//        Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
//        Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
//        Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green

        val game1 = Two.parseGame("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
        val game2 =
            Two.parseGame("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue")
        val game3 =
            Two.parseGame("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red")
        val game4 =
            Two.parseGame("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red")
        val game5 = Two.parseGame("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")

        Assert.assertEquals(48, game1.powerOfGame)
        Assert.assertEquals(12, game2.powerOfGame)
        Assert.assertEquals(1560, game3.powerOfGame)
        Assert.assertEquals(630, game4.powerOfGame)
        Assert.assertEquals(36, game5.powerOfGame)

    }
}