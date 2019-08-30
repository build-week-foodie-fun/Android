package com.versilistyson.foodieapp.views

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import com.versilistyson.foodieapp.R

class RatingCustomView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {



    var textView: TextView
    var ratingBar: RatingBar

    init {
        ratingBar = (context as Activity).layoutInflater.inflate(R.layout.rating_bar, null) as RatingBar
        orientation = VERTICAL
        ratingBar.numStars = 3
        ratingBar.stepSize = 1f
        addView(ratingBar)




        textView = TextView(context)
        textView.setTextColor(-0x1000000)
        textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        textView.textSize = 16f

        addView(textView)



    }
    fun changeRating(rating: Float) {
        textView.text = when {
            ratingBar.rating == 0f -> "Awful"
            ratingBar.rating == 1f -> "Meh..."
            ratingBar.rating == 2f -> "Tasty!"
            else -> "Superb!"
        }
    }
}