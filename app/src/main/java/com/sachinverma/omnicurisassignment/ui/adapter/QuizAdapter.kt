package com.sachinverma.omnicurisassignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sachinverma.omnicurisassignment.R
import com.sachinverma.omnicurisassignment.model.QuizInfo
import com.sachinverma.omnicurisassignment.ui.adapter.viewholder.QuizViewHolder

/**
 * Created by Sachin Verma on 2020-01-24.
 */

class QuizAdapter(val context: Context) : ListAdapter<QuizInfo, QuizViewHolder>(QuizDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = QuizViewHolder(context, LayoutInflater.from(parent.context).inflate(R.layout.quiz_item, parent, false))

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class QuizDiffUtil: DiffUtil.ItemCallback<QuizInfo>() {

        override fun areItemsTheSame(oldItem: QuizInfo, newItem: QuizInfo): Boolean {
            return oldItem.question.equals(newItem.question)
        }

        override fun areContentsTheSame(oldItem: QuizInfo, newItem: QuizInfo): Boolean {
            return oldItem == newItem
        }
    }


}