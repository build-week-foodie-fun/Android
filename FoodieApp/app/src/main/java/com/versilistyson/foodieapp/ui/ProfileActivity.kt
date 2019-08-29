package com.versilistyson.foodieapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.versilistyson.foodieapp.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btn_save.setOnClickListener{
            val homeIntent = Intent(this, HomePageActivity::class.java)
            startActivity(homeIntent)
        }
    }
}
