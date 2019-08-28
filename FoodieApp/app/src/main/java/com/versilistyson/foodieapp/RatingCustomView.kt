package com.versilistyson.foodieapp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.LinearLayout.VERTICAL
import android.widget.RatingBar
import android.widget.TextView

class RatingCustomView : View {
    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes)

    init {
        val mLinearLayout = LinearLayout(context)
        val foodRatingBar = LayoutInflater.from(context).inflate(R.layout.custom_rating_bar_layout,mLinearLayout , false) as RatingBar
        val ratingText = LayoutInflater.from(context).inflate(R.layout.food_ratingbar_textview, mLinearLayout, false) as TextView

        mLinearLayout.orientation = VERTICAL
        mLinearLayout.addView(foodRatingBar)
        mLinearLayout.addView(ratingText)
    }
}
