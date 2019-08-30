package com.versilistyson.foodieapp.model

import java.io.Serializable

class UserProfile (
    id : Int,
    email: String,
    firstName: String,
    lastName: String,
    password: String,
    confirmPassword: String
): Serializable {

    val id = id
    var email = email
    var firstName = firstName
    var lastName = lastName
    var password = password
    var confirmPassword = confirmPassword
}

object UserProfileList {
    var userProfile = mutableListOf<UserProfile>()
}