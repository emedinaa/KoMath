package com.emedinaa.komath.model.interactor

/**
 * Created by emedinaa on 26/05/17.
 */
interface DataCallback {

    fun onDataSuccess(obj:Any)
    fun onDataError(obj:Any)
}