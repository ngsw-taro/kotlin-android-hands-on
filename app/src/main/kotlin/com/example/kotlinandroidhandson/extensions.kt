package com.example.kotlinandroidhandson

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.support.annotation.IdRes
import android.view.View
import retrofit2.Retrofit
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun <T : View> View.findView(@IdRes id: Int): T = findViewById(id)

fun <T : Any> Retrofit.create(service: KClass<T>): T = create(service.java)

inline fun <reified T : Any> Retrofit.create(): T = create(T::class)

inline fun <reified T : Any> Context.intent(): Intent = Intent(this, T::class.java)

operator fun <T : Parcelable> Intent.get(name: String): T? = getParcelableExtra(name)

val Activity.app: App
    get() = application as App