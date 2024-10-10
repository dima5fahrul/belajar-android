package com.example.belajarandroid.networking_retrofit_api.data.response

import com.google.gson.annotations.SerializedName

data class CustomerReviewsItem(

    @field:SerializedName("date")
    val date: String,

    @field:SerializedName("review")
    val review: String,

    @field:SerializedName("name")
    val name: String
)