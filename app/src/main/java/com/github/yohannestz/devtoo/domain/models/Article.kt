package com.github.yohannestz.devtoo.domain.models

import com.github.yohannestz.devtoo.data.remote.dto.FlareTag
import com.github.yohannestz.devtoo.data.remote.dto.User

data class Article(
    val typeOf: String?,
    val id: Int?,
    val title: String?,
    val description: String?,
    val readablePublishDate: String?,
    val slug: String?,
    val path: String?,
    val commentsCount: Int?,
    val publicReactionsCount: Int?,
    val publishedTimeStamp: String?,
    val positiveReactionsCount: Int?,
    val coverImage: String?,
    val socialImage: String?,
    val canonicalUrl: String?,
    val readingTimeMinutes: Int?,
    val tagList: List<String>?,
    val tags: String?,
    val user: User?,
    val flareTag: FlareTag?
)