package com.versilistyson.foodieapp.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.versilistyson.foodieapp.R
import com.versilistyson.foodieapp.ReviewListFragment
import kotlinx.android.synthetic.main.activity_homepage.*

class HomePageActivity : AppCompatActivity(), ReviewListFragment.OnListFragmentInteractionListener  {
    override fun onListFragmentInteraction(item: DummyItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    companion object {
        const val imageRequestCode = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        add_review_fab.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), imageRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == imageRequestCode && resultCode == Activity.RESULT_OK) {
            //TODO: Open up activity or fragment for adding in data
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
