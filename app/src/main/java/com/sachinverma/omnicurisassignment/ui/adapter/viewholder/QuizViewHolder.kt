package com.sachinverma.omnicurisassignment.ui.adapter.viewholder

import android.content.Context
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sachinverma.omnicurisassignment.R
import com.sachinverma.omnicurisassignment.model.QuizInfo

/**
 * Created by Sachin Verma on 2020-01-24.
 */

class QuizViewHolder(val context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {



    private var tvQuestion: TextView = itemView.findViewById(R.id.tv_question)
    private var rgOptions: RadioGroup = itemView.findViewById(R.id.rg_quiz_options)
    private var tvResult: TextView = itemView.findViewById(R.id.tv_result)

    fun bind(quizInfo: QuizInfo) {

       tvQuestion.text = quizInfo.question
        var i = 0
        for (option in quizInfo.options) {
            val rboption = RadioButton(context)
            rboption.text = option
            rboption.id = i++
            rgOptions.addView(rboption)
        }


        rgOptions.setOnCheckedChangeListener { group, checkedId ->
            tvResult.visibility = View.VISIBLE
            if (rgOptions.findViewById<RadioButton>(checkedId).text.equals(quizInfo.correct)) {
                tvResult.text = "Correct"
            } else {
                tvResult.text = "Incorrect"
            }
        }
    }

}