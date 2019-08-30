package com.versilistyson.foodieapp

import android.content.Context
import android.content.res.TypedArray
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




    var ratingBar: RatingBar

    init {

        orientation = VERTICAL

        ratingBar = RatingBar(context,attrs, R.style.FoodRatingBar)
        ratingBar.numStars = 3
        ratingBar.stepSize = 1f
        ratingBar.isIndicator

        val attributes = context.obtainStyledAttributes(R.styleable.RatingCustomView)
        ratingBar.rating = attributes.getFloat(R.styleable.RatingCustomView_rating, 1f)
        attributes.recycle()

        addView(ratingBar)


        val textView = TextView(context)
        textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        textView.textSize = 16f
        textView.text = when {
            ratingBar.rating == 0f -> "Awful"
            ratingBar.rating == 1f -> "Meh..."
            ratingBar.rating == 2f -> "Tasty!"
            else -> "Superb!"
        }
        addView(textView)


    }

}