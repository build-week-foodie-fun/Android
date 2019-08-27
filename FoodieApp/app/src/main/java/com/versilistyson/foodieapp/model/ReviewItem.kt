package com.versilistyson.foodieapp.model

import java.io.Serializable

class ReviewItem (val foodImage: String, val foodName: String, val eatery: String, val reviewTitle: String, val reviewDescription: String, val rating: Float) : Serializable