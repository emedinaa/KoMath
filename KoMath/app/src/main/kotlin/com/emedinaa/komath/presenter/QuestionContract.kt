package com.emedinaa.komath.presenter

import com.emedinaa.komath.model.Question

/**
 * Created by emedinaa on 26/05/17.
 */
interface QuestionContract {

    interface QuestionView{

        fun showLoading()
        fun hideLoading()
        fun empty()
        fun receivedQuestions(questions:List<Question>)
        fun showMessage(message:String)

        fun renderQuestion(question:Question)
        fun nextQuestion()
    }

    interface AnswerView{

        fun showLoading()
        fun hideLoading()
        fun empty()
        fun showMessage(message:String)
        fun rateQuestion(question:Question)
        fun validatedAnswer(obj:Any)
    }
}