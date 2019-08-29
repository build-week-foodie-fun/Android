package com.versilistyson.foodieapp

import android.content.Context
import android.text.Layout
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import android.widget.RatingBar
import android.widget.TextView

class RatingCustomView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {
    init {
        orientation = VERTICAL
        val ratingBar = RatingBar(ContextThemeWrapper(context, R.style.FoodRatingBar))
        ratingBar.numStars = 3
        ratingBar.rating = 1f
        ratingBar.stepSize = 1f
        ratingBar.isIndicator
        val textView = TextView(context) as TextView
        textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        textView.textSize = 16f
        textView.text = when {
            ratingBar.numStars == 0 -> "Awful"
            ratingBar.numStars == 1 -> "Meh..."
            ratingBar.numStars == 2 -> "Tasty!"
            else -> "Superb!"
        }



    }


}