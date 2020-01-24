package com.sachinverma.omnicurisassignment.ui.activity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sachinverma.omnicurisassignment.model.QuizInfo
import com.sachinverma.omnicurisassignment.model.Response
import com.sachinverma.omnicurisassignment.utils.Constants
import java.io.FileReader


/**
 * Created by Sachin Verma on 2020-01-24.
 */

class MainViewModel : ViewModel() {

    private var _quizList = MutableLiveData<MutableList<QuizInfo>>()
    val quizList: LiveData<MutableList<QuizInfo>>
        get() = _quizList

    val gson = Gson()

    init {
        loadJsonData()
    }

    private fun loadJsonData() {
//        val response = gson.fromJson(FileReader("/Users/sachinverma/AndroidStudioProjects/sample-data.json"), Response::class.java)
        val response = gson.fromJson(Constants.JSON, Response::class.java)
        if (response.quizList.size > 0)
            _quizList.value = response.quizList
    }

}