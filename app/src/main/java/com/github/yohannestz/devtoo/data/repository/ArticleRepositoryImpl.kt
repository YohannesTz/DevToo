package com.github.yohannestz.devtoo.data.repository

import com.github.yohannestz.devtoo.data.remote.DevToArticlesApi
import com.github.yohannestz.devtoo.data.remote.dto.ArticleDetailDto
import com.github.yohannestz.devtoo.data.remote.dto.ArticleDto
import com.github.yohannestz.devtoo.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val api: DevToArticlesApi
): ArticleRepository {
    override suspend fun getArticles(): List<ArticleDto> {
        return api.getArticles()
    }

    override suspend fun getArticleById(articleId: Int): ArticleDetailDto {
        return api.getArticle(articleId)
    }
}