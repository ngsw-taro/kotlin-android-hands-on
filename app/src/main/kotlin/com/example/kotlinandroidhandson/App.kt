package com.example.kotlinandroidhandson

import android.app.Application
import com.example.kotlinandroidhandson.client.GithubClient
import com.facebook.drawee.backends.pipeline.Fresco
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.lazy
import com.github.salomonbrys.kodein.singleton
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class App : Application(), KodeinAware {

    override val kodein: Kodein by Kodein.lazy {
        bind<Gson>() with singleton {
            GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create()
        }

        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create(instance()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }

        // GithubClientの実装をDIに設定
        bind<GithubClient>() with singleton {
            instance<Retrofit>().create<GithubClient>()
        }
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}