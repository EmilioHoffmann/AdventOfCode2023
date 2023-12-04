package com.hoffmann.emilio.adventofcode2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hoffmann.emilio.adventofcode2023.one.One
import com.hoffmann.emilio.adventofcode2023.two.Two

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        One.main(this)
        Two.main(this)
    }
}