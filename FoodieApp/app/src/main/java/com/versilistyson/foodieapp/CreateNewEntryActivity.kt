package com.versilistyson.foodieapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_new_entry.*
import android.net.Uri

class CreateNewEntryActivity : AppCompatActivity() {

    var photoUri:Uri?=null

    companion object {

       var foodEntries= mutableListOf<FoodEntry>()
        internal const val REQUEST_IMAGE_GET = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_entry)

        btn_upload_image.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_GET)
            }
        }

        btn_submit_entry.setOnClickListener {

           foodEntries.add(FoodEntry(foodEntries.size-1,et_restaurant.toString(),et_restaurant_type.toString(),
                    et_food_item.toString(),photoUri, Integer.parseInt(et_rating.toString()),et_comments.toString(),et_price.toString(),et_date.toString()))
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

