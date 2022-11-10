package com.github.yohannestz.devtoo.presentation.articleList

import com.github.yohannestz.devtoo.domain.models.Article

data class ArticleListState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String = ""
)
