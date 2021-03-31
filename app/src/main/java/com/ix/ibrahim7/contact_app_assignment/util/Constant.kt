package com.ix.ibrahim7.contact_app_assignment.util

import android.R.attr.name
import android.R.id
import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.firebase.analytics.FirebaseAnalytics
import com.ix.ibrahim7.contact_app_assignment.util.Constant.trackScreen
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.round


object Constant {

    fun Activity.trackScreen(screenName:String,key: String, data:String) {
        val bundle = Bundle().apply {
            putString(key, data)
        }
        FirebaseAnalytics.getInstance(this).logEvent(screenName, bundle)
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter(value = ["value"], requireAll = false)
    fun getCategory(view: View, value:Any){
                val imageView = view as ImageView
               imageView.setImageResource(value as Int)
    }


}