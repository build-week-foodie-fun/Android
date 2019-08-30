package com.versilistyson.foodieapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.versilistyson.foodieapp.R
import com.versilistyson.foodieapp.model.UserProfile
import com.versilistyson.foodieapp.model.UserProfileList
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_submit.setOnClickListener {

            val userProfile = UserProfile(
                UserProfileList.userProfile.size -1,
                et_email.text.toString(),
                et_first_name.text.toString(),
                et_last_name.text.toString(),
                et_password.text.toString(),
                et_confirm_password.text.toString())

            UserProfileList.userProfile.add(userProfile)

            var registrationIntent = Intent(this, AppLauncherActivity::class.java)
            startActivity(registrationIntent)
        }
    }
}
