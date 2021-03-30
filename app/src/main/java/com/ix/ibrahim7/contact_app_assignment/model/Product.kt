package com.ix.ibrahim7.contact_app_assignment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val id: Int, val categoriesID: Int, val name: String,
    val description: String, val rating: Float, val pathImage: Int, var price: Int = 40
) : Parcelable