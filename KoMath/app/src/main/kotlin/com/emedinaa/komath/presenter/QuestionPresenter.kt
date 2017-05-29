package com.emedinaa.komath.presenter

import com.emedinaa.komath.model.Question
import com.emedinaa.komath.model.interactor.DataCallback
import com.emedinaa.komath.model.interactor.QuestionCase

/**
 * Created by emedinaa on 27/05/17.
 */
class QuestionPresenter(var view:QuestionContract.QuestionView,
                        var questionCase: QuestionCase):DataCallback{

    override fun onDataSuccess(obj: Any) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        view.hideLoading()
        var questions:List<Question> = obj as List<Question>
        if(questions.isEmpty()){
            view.empty()
        }else{
            view.receivedQuestions(questions)
        }
    }

    override fun onDataError(obj: Any) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        view.hideLoading()
        var exception:Exception= obj as Exception
        view.showMessage(exception.message!!)
    }

    fun getQuestions(){
        view.showLoading()
        questionCase.getQuestions(this)
    }
}