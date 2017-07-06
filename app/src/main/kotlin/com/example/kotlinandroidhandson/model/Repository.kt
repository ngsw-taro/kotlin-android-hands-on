package com.example.kotlinandroidhandson.model

import org.parceler.Parcel
import org.parceler.ParcelConstructor
import org.parceler.ParcelProperty


@Parcel
data class Repository
@ParcelConstructor
constructor(@ParcelProperty("id") val id: Long,
            @ParcelProperty("fullName") val fullName: String,
            @ParcelProperty("htmlUrl") val htmlUrl: String,
            @ParcelProperty("stargazersCount") val stargazersCount: Int,
            @ParcelProperty("owner") val owner: User,
            @ParcelProperty("description") val description: String? = null,
            @ParcelProperty("language") val language: String? = null)