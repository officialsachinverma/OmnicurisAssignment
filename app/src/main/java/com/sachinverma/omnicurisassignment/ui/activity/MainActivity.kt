package com.sachinverma.omnicurisassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.sachinverma.omnicurisassignment.ui.activity.viewmodel.MainViewModel
import com.sachinverma.omnicurisassignment.ui.adapter.QuizAdapter

class MainActivity : AppCompatActivity() {


    @BindView(R.id.rv_quiz)
    lateinit var rvQuiz: RecyclerView

    private lateinit var adapter: QuizAdapter
    private lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        init()
    }


    fun init() {
        model = MainViewModel()

        initAdapter()
        observeForObserver()

    }

    private fun observeForObserver() {
        model.quizList.observe(this, Observer {
            if (it.size > 0)
                adapter.submitList(it)
        })
    }

    private fun initAdapter() {
        adapter = QuizAdapter(this)
        val linearLayout = LinearLayoutManager(this)
        linearLayout.orientation = LinearLayoutManager.VERTICAL
        rvQuiz.layoutManager = linearLayout
        rvQuiz.adapter = adapter
    }
}
