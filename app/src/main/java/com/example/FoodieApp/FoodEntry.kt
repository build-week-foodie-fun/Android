package com.example.FoodieApp

import android.net.Uri
import java.io.Serializable

class FoodEntry(id:Int,restaurant_name:String,restaurant_type:String,item_name:
String,photoUri:Uri,food_rating:Int,comments:String,price:Double,wait_time:String,date_of_visit:String):Serializable{

    val id=id
    var restaurant_name=restaurant_name
    var restaurant_type=restaurant_type
    var item_name=item_name
    val photoUri=photoUri
    var food_rating=food_rating
    var comments=comments
    var price=price
    var wait_time=wait_time
    var date_of_visit=date_of_visit

}