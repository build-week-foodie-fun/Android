package com.versilistyson.foodieapp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View

class RatingCustomView : View {
    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int): super(context, attrs, defStyleAttr, defStyleRes)

    init {
        val foodRatingBar = LayoutInflater.from(context).inflate(R.layout.custom_rating_bar_layout)
    }
}