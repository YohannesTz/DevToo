package com.github.yohannestz.devtoo.data.remote.dto

import com.github.yohannestz.devtoo.domain.models.ArticleDetail

data class ArticleDetailDto(
    val body_html: String,
    val body_markdown: String,
    val canonical_url: String,
    val collection_id: Any,
    val comments_count: Int,
    val cover_image: String,
    val created_at: String,
    val crossposted_at: Any,
    val description: String,
    val edited_at: Any,
    val flare_tag: FlareTag,
    val id: Int,
    val last_comment_at: String,
    val path: String,
    val positive_reactions_count: Int,
    val public_reactions_count: Int,
    val published_at: String,
    val published_timestamp: String,
    val readable_publish_date: String,
    val reading_time_minutes: Int,
    val slug: String,
    val social_image: String,
    val tag_list: String,
    val tags: List<String>,
    val title: String,
    val type_of: String,
    val url: String,
    val user: User
)

fun ArticleDetailDto.toArticleDetail(): ArticleDetail {
    return ArticleDetail(
        typeOf = type_of,
        id = id,
        title = title,
        description = description,
        readablePublishDate = readable_publish_date,
        slug = slug,
        path = path,
        url = url,
        commentsCount = comments_count,
        publicReactionsCount = public_reactions_count,
        publishedTimestamp = published_timestamp,
        coverImage = cover_image,
        socialImage = social_image,
        canonicalUrl = canonical_url,
        readingTimeMinutes = reading_time_minutes,
        tags = tags,
        tagsList = tag_list,
        bodyHtml = body_html,
        bodyMarkDown = body_markdown,
        user = user,
        flareTag = flare_tag
    )
}