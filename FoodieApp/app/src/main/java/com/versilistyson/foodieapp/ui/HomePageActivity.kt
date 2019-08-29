package com.versilistyson.foodieapp.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.versilistyson.foodieapp.CreateNewEntryActivity
import com.versilistyson.foodieapp.FoodEntry
import com.versilistyson.foodieapp.R
import com.versilistyson.foodieapp.ReviewListFragment
import kotlinx.android.synthetic.main.activity_homepage.*

class HomePageActivity : AppCompatActivity(),ReviewListFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        add_review_fab.setOnClickListener {
            val intent = Intent(this,CreateNewEntryActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onListFragmentInteraction(item: FoodEntry?) {


    }



}
