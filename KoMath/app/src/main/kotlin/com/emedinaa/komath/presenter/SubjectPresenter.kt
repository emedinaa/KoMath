package com.emedinaa.komath.presenter

import com.emedinaa.komath.model.Subject
import com.emedinaa.komath.model.interactor.DataCallback
import com.emedinaa.komath.model.interactor.SubjectCase

/**
 * Created by emedinaa on 26/05/17.
 */
class SubjectPresenter(var view:SubjectContract.SubjectView,var subjectCase:SubjectCase):DataCallback {

    override fun onDataSuccess(obj: Any) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        view.hideLoading()
        var subjects:List<Subject> = obj as List<Subject>
        if(subjects.isEmpty()){
            view.empty()
        }else{
            view.renderSubjects(subjects)
        }
    }

    override fun onDataError(obj: Any) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        view.hideLoading()
        var exception:Exception= obj as Exception
        view.showMessage(exception.message!!)
    }

    fun getSubjects(){
        view.showLoading()
        subjectCase.getSubjects(this)
    }
}