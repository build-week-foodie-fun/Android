package com.versilistyson.foodieapp.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.versilistyson.foodieapp.R
import kotlinx.android.synthetic.main.activity_details.*
import com.versilistyson.foodieapp.model.FoodEntryList.foodEntries
import kotlinx.android.synthetic.main.activity_create_new_entry.*


class DetailsActivity : AppCompatActivity() {
    var photoUri: Uri?=null
    companion object {
        internal const val REQUEST_IMAGE_GET = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
       val id = intent.getIntExtra("FOOD_ENTRY_ID",1)
        det_restaurant.setText(foodEntries[id].restaurant_name)
       det_restaurant_type.setText(foodEntries[id].restaurant_type)
        det_food_item.setText(foodEntries[id].item_name)
        det_date.setText(foodEntries[id].date_of_visit)
        det_price.setText(foodEntries[id].price)
        det_rating.rating=foodEntries[id].food_rating
        det_comments.setText(foodEntries[id].comments)
        dim_upload_image.setImageURI(foodEntries[id].photoUri)

        dbtn_edit_entry.setOnClickListener {
           foodEntries[id].restaurant_name=det_restaurant.text.toString()
            foodEntries[id].restaurant_type=det_restaurant_type.text.toString()
             foodEntries[id].item_name=det_food_item.text.toString()
             foodEntries[id].date_of_visit=det_date.text.toString()
             foodEntries[id].price=det_price.text.toString()
             foodEntries[id].food_rating=det_rating.rating
             foodEntries[id].comments=det_comments.text.toString()
             if(photoUri!=null){foodEntries[id].photoUri=photoUri}
             val intent = Intent(this, HomePageActivity::class.java)
             startActivity(intent)
        }
        dbtn_delete.setOnClickListener {

            foodEntries.removeAt(id)
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)

        }
        dbtn_back.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
        dbtn_upload_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent,
                    REQUEST_IMAGE_GET
                )
            }
        }

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        det_date.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                et_date.setText(""+ (mMonth+1) +"/"+ mDay +"/"+ mYear)
            }, year, month, day)
            dpd.show()
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            val uri = data!!.data
            photoUri=uri
            dim_upload_image.setImageURI(uri)

        }
    }

}
