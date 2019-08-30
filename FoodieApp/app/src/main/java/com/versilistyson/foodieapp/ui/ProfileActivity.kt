package com.versilistyson.foodieapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.versilistyson.foodieapp.R
import com.versilistyson.foodieapp.model.UserProfileList
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val id = intent.getIntExtra("USER_ENTRY",1)
        et_user_email.setText(UserProfileList.userProfile[id-1].email)
        et_user_first_name.setText(UserProfileList.userProfile[id-1].firstName)
        et_user_last_name.setText(UserProfileList.userProfile[id-1].lastName)
        et_user_password.setText(UserProfileList.userProfile[id-1].password)
        et_user_confirm_password.setText(UserProfileList.userProfile[id-1].confirmPassword)

        btn_save.setOnClickListener{
            val homeIntent = Intent(this, HomePageActivity::class.java)
            startActivity(homeIntent)
        }
    }
}
