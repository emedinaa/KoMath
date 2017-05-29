package com.emedinaa.komath.model.interactor

import com.emedinaa.komath.data.ApiClient
import com.emedinaa.komath.data.model.SubjectReponse
import com.emedinaa.komath.utils.log

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by emedinaa on 26/05/17.
 */
class SubjectInteractor:SubjectCase {

    private var dataCallback:DataCallback?= null

    private val subjectCallback:Callback<SubjectReponse> = object:Callback<SubjectReponse>{

        override fun onFailure(call: Call<SubjectReponse>?, t: Throwable?) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            dataCallback!!.onDataError(Exception(t))
        }

        override fun onResponse(call: Call<SubjectReponse>?, response: Response<SubjectReponse>?) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            log ({"onResponse $response"})

            if(response!!.isSuccessful){
                dataCallback!!.onDataSuccess(response.body().data)
            }else{
                dataCallback!!.onDataError(Exception(response.message()))
            }
        }

    }

    override fun getSubjects(callback: DataCallback) {
        dataCallback= callback
        var call:Call<SubjectReponse> = ApiClient.getMyApiClient().subjects()
        call.enqueue(subjectCallback)
    }
}