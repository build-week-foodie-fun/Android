package com.versilistyson.foodieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.versilistyson.foodieapp.ui.HomePageActivity
import kotlinx.android.synthetic.main.activity_app_launcher.*

class AppLauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_launcher)

       signIn.setOnClickListener {
           val intent = Intent(this,HomePageActivity::class.java)
           startActivity(intent)
       }
    }
}
