package com.emedinaa.komath

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.emedinaa.komath.utils.log
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by emedinaa on 21/05/17.
 */
class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ui()
    }

    private fun ui() {
        textViewStart.setOnClickListener {
            log { "Hello Kotlin" }
        }
    }


}