package com.versilistyson.foodieapp.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.versilistyson.foodieapp.*
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

        user_icon.setOnClickListener {
            var editUserIntent = Intent(this, ProfileActivity::class.java)
            startActivity(editUserIntent)
        }
    }
    //

    override fun onListFragmentInteraction(item: FoodEntry?) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("FOOD_ENTRY_ID",item?.id)
        startActivity(intent)

    }
}
