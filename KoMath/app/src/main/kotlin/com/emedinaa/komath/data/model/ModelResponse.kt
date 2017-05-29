package com.emedinaa.komath.data.model

import com.emedinaa.komath.model.Question
import com.emedinaa.komath.model.Subject
import com.emedinaa.komath.model.User

/**
 * Created by emedinaa on 26/05/17.
 */
data class SubjectReponse(val msg:String,val status:Int, val data:List<Subject>)

data class QuestionReponse(val msg:String,val status:Int, val data:List<Question>)

data class UserReponse(val msg:String,val status:Int, val data:User)