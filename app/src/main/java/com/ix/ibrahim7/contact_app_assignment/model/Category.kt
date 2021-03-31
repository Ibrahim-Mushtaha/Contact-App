package com.ix.ibrahim7.contact_app_assignment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val id:Int,
    val title:String?,
    val image : Int
) : Parcelable