package com.versilistyson.foodieapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.versilistyson.foodieapp.AppLauncherActivity
import com.versilistyson.foodieapp.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btn_submit.setOnClickListener {
            var registrationIntent = Intent(this, AppLauncherActivity::class.java)
            startActivity(registrationIntent)
        }
    }
}
