package com.github.yohannestz.devtoo.domain.models

import com.github.yohannestz.devtoo.data.remote.dto.FlareTag
import com.github.yohannestz.devtoo.data.remote.dto.User

data class ArticleDetail(
    val typeOf: String?,
    val id: Int?,
    val title: String?,
    val description: String?,
    val readablePublishDate: String?,
    val slug: String?,
    val path: String?,
    val url: String?,
    val commentsCount: Int?,
    val publicReactionsCount: Int?,
    val publishedTimestamp: String?,
    val coverImage: String?,
    val socialImage: String?,
    val canonicalUrl: String?,
    val readingTimeMinutes: Int?,
    val tags: List<String>?,
    val tagsList: String?,
    val bodyHtml: String?,
    val bodyMarkDown: String?,
    val user: User?,
    val flareTag: FlareTag?
)
