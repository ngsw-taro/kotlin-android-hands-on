package com.example.kotlinandroidhandson

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import com.example.kotlinandroidhandson.model.Repository

class RepositoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        val repository: Repository = intent["repository"] ?: throw IllegalStateException("repositoryがないよ")
//        title = repository.fullName
//
//        val repositoryView = findViewById(R.id.repository_view) as RepositoryView
//        repositoryView.setRepository(repository)
//
//        val webView = findViewById(R.id.web_view) as WebView
//        webView.loadUrl(repository.htmlUrl)
    }
}