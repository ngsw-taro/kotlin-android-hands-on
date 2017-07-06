package com.example.kotlinandroidhandson.model

data class Page<out T>(val totalCount: Long,
                       val items: List<T>)