package com.github.yohannestz.devtoo.presentation.articleDetail

import com.github.yohannestz.devtoo.domain.models.ArticleDetail

data class ArticleDetailState(
    val isLoading: Boolean = false,
    val article: ArticleDetail? = null,
    val error: String = ""
)
