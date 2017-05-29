package com.emedinaa.komath

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.emedinaa.komath.ui.SubjectActivity
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

    fun goToSubjects(){
        val intent= Intent(this,SubjectActivity::class.java)
        startActivity(intent)
    }

    private fun ui() {
        //textViewHello.text="Hello Kotlin"
        textViewStart.setOnClickListener {
            goToSubjects()
        }
    }


}