package com.emedinaa.komath.model

import java.io.Serializable

/**
 * Created by emedinaa on 26/05/17.
 */


data class User(val id:String?,val username:String, val password:String,val firstname:String,
                val lastname:String):Serializable

data class Subject(val id:String, val name:String, val color:String):Serializable

data class Question(val id:String, val subjectId:String, val levelId:Int,
                    val title:String,val options:String, val format:String):Serializable
