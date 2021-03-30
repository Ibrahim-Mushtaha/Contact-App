package com.ix.ibrahim7.contact_app_assignment.util

import android.R.attr.name
import android.R.id
import android.app.Activity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics


object Constant {

    fun Activity.trackScreen(screenName:String,id:String,name:String,image:String){
        val bundle = Bundle().apply {
            putString(FirebaseAnalytics.Param.ITEM_ID,id)
            putString(FirebaseAnalytics.Param.ITEM_NAME, name)
            putString(FirebaseAnalytics.Param.CONTENT_TYPE, image)
        }
        FirebaseAnalytics.getInstance(this).logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }


}