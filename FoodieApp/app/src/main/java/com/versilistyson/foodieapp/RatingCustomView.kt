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

class RatingCustomView: LinearLayout {

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes)

    companion object {
        private const val DEFAULT_RATING = 1f
    }

    init {
        orientation = VERTICAL
        val contextThemeWrapper = ContextThemeWrapper(context, R.style.FoodRatingBar)
        val ratingBar = RatingBar(contextThemeWrapper)
        ratingBar.numStars = 3
        ratingBar.rating = 1f
        ratingBar.stepSize = 1f
        ratingBar.isIndicator
        val textView = TextView(context)
        textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        textView.textSize = 16f
        textView.text = when {
            ratingBar.numStars == 0 -> "Awful"
            ratingBar.numStars == 1 -> "Meh..."
            ratingBar.numStars == 2 -> "Tasty!"
            else -> "Superb!"
        }



    }
    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(R.styleable.RatingCustomView)
        val rating = typedArray.getFloat(R.styleable.RatingCustomView_rating, DEFAULT_RATING)

        typedArray.recycle()
    }


}