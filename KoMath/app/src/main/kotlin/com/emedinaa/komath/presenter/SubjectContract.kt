package com.emedinaa.komath.presenter

import com.emedinaa.komath.model.Subject

/**
 * Created by emedinaa on 26/05/17.
 */
interface SubjectContract {

    interface SubjectView{

        fun showLoading()
        fun hideLoading()
        fun empty()
        fun renderSubjects(subjects:List<Subject>)
        fun showMessage(message:String)
    }
}