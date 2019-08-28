package com.versilistyson.foodieapp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import android.widget.RatingBar
import android.widget.TextView
import kotlinx.android.synthetic.main.custom_rating_bar_layout.view.*

class RatingCustomView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {
    init {
        val ratingBarLayout = LayoutInflater.from(context).inflate(R.layout.custom_rating_bar_layout, this, false) as LinearLayout
        val textView = ratingBarLayout.rating_tv
        val ratingBar = ratingBarLayout.rating_bar

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.RatingCustomView)
        textView.text = when {
            ratingBar.numStars == 1 -> "Awful!"
            ratingBar.numStars == 2 -> "Meh..."
            else -> "Excellent"
        }
        attributes.recycle()
    }
}