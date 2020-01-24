package com.sachinverma.omnicurisassignment.model

/**
 * Created by Sachin Verma on 2020-01-24.
 */

data class Response(var status:String,
                    var quizList: ArrayList<QuizInfo>)