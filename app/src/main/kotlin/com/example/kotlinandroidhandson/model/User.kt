package com.example.kotlinandroidhandson.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val id: Long,
                @SerializedName("login") val loginId: String,
                val avatarUrl: String?) : Parcelable