package com.emedinaa.komath.utils

import android.util.Log
import com.emedinaa.komath.BuildConfig

/**
 * Created by emedinaa on 26/05/17.
 */

fun log(lambda: () -> String) {
    if (BuildConfig.DEBUG) {
        Log.d("TAG", lambda())
    }
}