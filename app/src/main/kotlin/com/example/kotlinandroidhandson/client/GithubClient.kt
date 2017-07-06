package com.example.kotlinandroidhandson.client

import com.example.kotlinandroidhandson.model.Page
import com.example.kotlinandroidhandson.model.Repository
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubClient {

    @GET("/search/repositories")
    fun search(@Query("q") query: String): Single<Page<Repository>>
}