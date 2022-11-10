package com.github.yohannestz.devtoo.data.remote.dto

import com.github.yohannestz.devtoo.domain.models.Article

data class ArticleDto(
    val canonical_url: String,
    val collection_id: Int,
    val comments_count: Int,
    val cover_image: String,
    val created_at: String,
    val crossposted_at: Any,
    val description: String,
    val edited_at: String,
    val flare_tag: FlareTag,
    val id: Int,
    val last_comment_at: String,
    val organization: Organization,
    val path: String,
    val positive_reactions_count: Int,
    val public_reactions_count: Int,
    val published_at: String,
    val published_timestamp: String,
    val readable_publish_date: String,
    val reading_time_minutes: Int,
    val slug: String,
    val social_image: String,
    val tag_list: List<String>,
    val tags: String,
    val title: String,
    val type_of: String,
    val url: String,
    val user: User
)

fun ArticleDto.toArticle(): Article {
    return Article(
        id = id,
        typeOf = type_of,
        title = title,
        description = description,
        readablePublishDate = readable_publish_date,
        slug = slug,
        path = path,
        commentsCount = comments_count,
        publicReactionsCount = public_reactions_count,
        publishedTimeStamp = published_timestamp,
        positiveReactionsCount = positive_reactions_count,
        coverImage = cover_image,
        socialImage = social_image,
        canonicalUrl = canonical_url,
        readingTimeMinutes = reading_time_minutes,
        tagList = tag_list,
        tags = tags,
        user = user,
        flareTag = flare_tag
    )
}