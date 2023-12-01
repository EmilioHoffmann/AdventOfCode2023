package com.hoffmann.emilio.adventofcode2023.utils

import android.content.res.Resources
import java.io.BufferedReader
import java.io.InputStreamReader

fun getStringListFromFile(fileId: Int, resources: Resources): List<String> {
    val fileInputStream = resources.openRawResource(fileId)
    val inputStreamReader = InputStreamReader(fileInputStream)
    val bufferedReader = BufferedReader(inputStreamReader)
    val lines = mutableListOf<String>()

    var line: String? = bufferedReader.readLine()
    while (line != null) {
        lines.add(line)
        line = bufferedReader.readLine()
    }

    bufferedReader.close()
    inputStreamReader.close()
    fileInputStream.close()

    return lines
}