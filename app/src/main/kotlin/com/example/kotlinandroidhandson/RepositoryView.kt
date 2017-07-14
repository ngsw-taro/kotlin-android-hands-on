package com.example.kotlinandroidhandson

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.kotlinandroidhandson.model.Repository
import com.facebook.drawee.view.SimpleDraweeView

class RepositoryView : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_repository, this)
        val padding = resources.getDimension(R.dimen.card_padding).toInt()
        setPadding(padding, padding, padding, padding)
    }

    val userAvatarView: SimpleDraweeView = findView(R.id.user_avatar_view)

    val repositoryNameView: TextView = findView(R.id.repository_name_view)

    val repositoryDescriptionView: TextView = findView(R.id.repository_description_view)

    val repositoryLanguageView: TextView = findView(R.id.repository_language_view)

    val repositoryStargazerCountView: TextView = findView(R.id.repository_stargazer_count_view)

    fun setRepository(repository: Repository) {
//        repository.run {
//            owner.avatarUrl?.let(userAvatarView::setImageURI)
//            repositoryNameView.text = fullName
//            repositoryDescriptionView.text = description
//            repositoryLanguageView.text = language
//            repositoryStargazerCountView.text = context.getString(R.string.stargazer_count, stargazersCount)
//        }
    }
}