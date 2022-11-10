package com.github.yohannestz.devtoo.domain.repository

import com.github.yohannestz.devtoo.data.remote.dto.ArticleDetailDto
import com.github.yohannestz.devtoo.data.remote.dto.ArticleDto

interface ArticleRepository {

    suspend fun getArticles(): List<ArticleDto>

    suspend fun getArticleById(articleId: Int): ArticleDetailDto
}