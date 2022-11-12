package com.github.yohannestz.devtoo.data.remote

import com.github.yohannestz.devtoo.data.remote.dto.ArticleDetailDto
import com.github.yohannestz.devtoo.data.remote.dto.ArticleDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DevToArticlesApi {

    @GET("/api/articles")
    suspend fun getArticles(
        @Query("page") page: Int, @Query("per_page") perPage: Int = 10): List<ArticleDto>

    @GET("/api/articles/{id}")
    suspend fun getArticle(@Path("id") id: Int): ArticleDetailDto
}