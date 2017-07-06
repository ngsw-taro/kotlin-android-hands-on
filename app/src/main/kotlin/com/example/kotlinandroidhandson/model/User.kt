package com.example.kotlinandroidhandson.model

import com.google.gson.annotations.SerializedName
import org.parceler.Parcel
import org.parceler.ParcelConstructor
import org.parceler.ParcelProperty

@Parcel
data class User
@ParcelConstructor
constructor(@ParcelProperty("id") val id: Long,
            @ParcelProperty("loginId") @SerializedName("login") val loginId: String,
            @ParcelProperty("avatarUrl") val avatarUrl: String?)