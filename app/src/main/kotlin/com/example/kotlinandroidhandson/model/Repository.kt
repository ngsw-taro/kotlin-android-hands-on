package com.example.kotlinandroidhandson.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(val id: Long,
                      val fullName: String,
                      val htmlUrl: String,
                      val stargazersCount: Int,
                      val owner: User,
                      val description: String? = null,
                      val language: String? = null) : Parcelable