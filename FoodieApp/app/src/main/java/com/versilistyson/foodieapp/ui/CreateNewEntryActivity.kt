package com.versilistyson.foodieapp.ui
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_new_entry.*
import android.net.Uri
import com.versilistyson.foodieapp.R
import com.versilistyson.foodieapp.model.FoodEntry
import com.versilistyson.foodieapp.model.FoodEntryList

class CreateNewEntryActivity : AppCompatActivity() {

    var photoUri:Uri?=null

    companion object {
        internal const val REQUEST_IMAGE_GET = 1
        const val REVIEW_IMAGE = "REVIEW_IMAGE"
        const val DATE = "DATE"
        const val PRICE = "PRICE"
        const val RATING = "RATING"
        const val RESTAURANT = "RESTAURANT"
        const val RESTAURANT_TYPE = "RESTAURANT_TYPE"
        const val COMMENTS = "COMMENTS"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_entry)

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        et_date.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                et_date.setText(""+ (mMonth+1) +"/"+ mDay +"/"+ mYear)
            }, year, month, day)
            dpd.show()
        }

        btn_upload_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent,
                    REQUEST_IMAGE_GET
                )
            }
        }

        btn_submit_entry.setOnClickListener {

            val foodEntry = FoodEntry(
                FoodEntryList.foodEntries.size - 1,
                et_restaurant.text.toString(),
                et_restaurant_type.text.toString(),
                et_food_item.text.toString(),
                photoUri,
                new_entry_rating_bar.rating,
                et_comments.text.toString(),
                et_price.text.toString(),
                et_date.text.toString()
            )

            FoodEntryList.foodEntries.add(foodEntry)

            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            val uri = data!!.data
            photoUri=uri
            im_upload_image.setImageURI(uri)

        }
    }
}

