package com.emedinaa.komath.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.emedinaa.komath.R
import kotlinx.android.synthetic.main.activity_level_completed.*

class LevelCompletedActivity : AppCompatActivity() {

    fun closeView(){
        finish()
    }

    fun  ui(){
        buttonNext.setOnClickListener {
            closeView()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_completed)
        ui()
    }
}
