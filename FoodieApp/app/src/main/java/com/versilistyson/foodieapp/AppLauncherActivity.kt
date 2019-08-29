package com.versilistyson.foodieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.versilistyson.foodieapp.ui.HomePageActivity
import com.versilistyson.foodieapp.ui.RegisterActivity
import kotlinx.android.synthetic.main.activity_app_launcher.*

class AppLauncherActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_HOMEPAGE = 0
        const val REQUEST_REGISTRATION = 1
        const val REQUEST_LOGIN = 2
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_launcher)

        signIn.setOnClickListener {
            var signInIntent = Intent(this, HomePageActivity::class.java)
            startActivity(signInIntent)
        }

        register.setOnClickListener {
            var registerIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registerIntent)
        }
    }
}