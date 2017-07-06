package com.example.kotlinandroidhandson

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import com.example.kotlinandroidhandson.model.Repository

class RepositoryActivity : AppCompatActivity() {

    companion object {
        fun intent(context: Context, repository: Repository): Intent =
                context.intent<RepositoryActivity>()
                        .putExtra("repository", repository.toParcelable())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        val repository: Repository = intent["repository"] ?: throw IllegalStateException("repositoryがないよ")
        title = repository.fullName

        val repositoryView = findViewById<RepositoryView>(R.id.repository_view)
        repositoryView.setRepository(repository)

        val webView = findViewById<WebView>(R.id.web_view)
        webView.loadUrl(repository.htmlUrl)
    }
}