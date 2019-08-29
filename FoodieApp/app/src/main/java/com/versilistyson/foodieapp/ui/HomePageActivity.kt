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

class HomePageActivity : AppCompatActivity(), ReviewListFragment.OnListFragmentInteractionListener  {

    companion object {
        const val REQUEST_REVIEW = 0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        add_review_fab.setOnClickListener {
            var createNewEntryIntent = Intent(this, CreateNewEntryActivity::class.java)
            startActivity(createNewEntryIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_REVIEW && resultCode == RESULT_OK) {

        }
    }

    override fun onListFragmentInteraction(item: FoodEntry?) {

    }
}
