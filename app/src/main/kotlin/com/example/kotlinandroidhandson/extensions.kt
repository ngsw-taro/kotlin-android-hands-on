package com.example.kotlinandroidhandson

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.support.annotation.IdRes
import android.view.View
import kotlinx.coroutines.experimental.suspendCancellableCoroutine
import org.parceler.Parcels
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
fun <T : View> View.findView(@IdRes id: Int): T = findViewById(id) as T

fun <T : Any> Retrofit.create(service: KClass<T>): T = create(service.java)

inline fun <reified T : Any> Retrofit.create(): T = create(T::class)

inline fun <reified T : Any> Context.intent(): Intent = Intent(this, T::class.java)

operator fun <T> Intent.get(name: String): T? = getParcelableExtra<Parcelable>(name)?.unwrap()

val Activity.app: App
    get() = application as App

suspend fun <T : Any> Call<T>.await(): T = suspendCancellableCoroutine { continuation ->
    enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            val result = response.body()
            if (result != null) {
                continuation.resume(result)
            } else {
                continuation.resumeWithException(NullPointerException())
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            continuation.resumeWithException(t)
        }
    })
}

fun Any.toParcelable(): Parcelable = Parcels.wrap(this)
fun <T> Parcelable.unwrap(): T = Parcels.unwrap(this)