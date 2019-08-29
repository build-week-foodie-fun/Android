package com.versilistyson.foodieapp
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_new_entry.*
import android.net.Uri
import com.versilistyson.foodieapp.ui.HomePageActivity

class CreateNewEntryActivity : AppCompatActivity() {

    var photoUri:Uri?=null

    companion object {

       var foodEntries= mutableListOf<FoodEntry>()
        internal const val REQUEST_IMAGE_GET = 1
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
                startActivityForResult(intent, REQUEST_IMAGE_GET)
            }
        }

        btn_submit_entry.setOnClickListener {

           foodEntries.add(FoodEntry(foodEntries.size-1,et_restaurant.toString(),et_restaurant_type.toString(),
                    et_food_item.toString(),photoUri, new_entry_rating_bar.rating,et_comments.toString(),et_price.toString(),et_date.toString()))


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

