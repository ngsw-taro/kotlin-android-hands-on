package com.example.kotlinandroidhandson

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import com.example.kotlinandroidhandson.client.GithubClient
import com.github.salomonbrys.kodein.KodeinInjected
import com.github.salomonbrys.kodein.KodeinInjector
import com.github.salomonbrys.kodein.instance
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.experimental.Job

class MainActivity : AppCompatActivity(), KodeinInjected {

    override val injector: KodeinInjector = KodeinInjector()

    val githubClient: GithubClient by instance()

    var disposable: Disposable? = null

    var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject(app.kodein)
        setContentView(R.layout.activity_main)

        val listAdapter = RepositoryListAdapter(this)
        val listView = findViewById(R.id.list_view) as ListView
        listView.adapter = listAdapter

        // リポジトリリストのアイテムをタップしたときの処理
        listView.setOnItemClickListener { _, _, position, _ ->
            // タップした位置のリポジトリを取得
            val repository = listAdapter.repositories[position]

            /* ここでリポジトリ詳細画面を起動する */
        }

        val searchEditText = findViewById(R.id.search_edit_text) as EditText
        val searchButton = findViewById(R.id.search_button) as Button

        // Searchボタンを押したときの処理
        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()

            // 問い合わせ
            val page = githubClient.search(query).blockingGet()

            // 取得したページのアイテムをリストに反映
            listAdapter.repositories = page.items
            listAdapter.notifyDataSetChanged()
        }
    }

    override fun onDestroy() {
        disposable?.dispose()
        job?.cancel()
        super.onDestroy()
    }
}