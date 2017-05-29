package com.emedinaa.komath.model.interactor

import com.emedinaa.komath.data.ApiClient
import com.emedinaa.komath.data.model.QuestionReponse
import com.emedinaa.komath.utils.log

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by emedinaa on 26/05/17.
 */
class QuestionInteractor:QuestionCase {

    private var dataCallback:DataCallback?= null

    private val questionCallback:Callback<QuestionReponse> = object:Callback<QuestionReponse>{

        override fun onFailure(call: Call<QuestionReponse>?, t: Throwable?) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            dataCallback!!.onDataError(Exception(t))
        }

        override fun onResponse(call: Call<QuestionReponse>?, response: Response<QuestionReponse>?) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            log ({"onResponse $response"})

            if(response!!.isSuccessful){
                dataCallback!!.onDataSuccess(response.body().data)
            }else{
                dataCallback!!.onDataError(Exception(response.message()))
            }
        }

    }

    override fun getQuestions(callback: DataCallback) {
        dataCallback= callback
        var call:Call<QuestionReponse> = ApiClient.getMyApiClient().questions()
        call.enqueue(questionCallback)
    }
}