package com.github.yohannestz.devtoo.data.remote.dto

data class User(
    val github_username: String,
    val name: String,
    val profile_image: String,
    val profile_image_90: String,
    val twitter_username: String,
    val user_id: Int,
    val username: String,
    val website_url: String
)