package com.github.yohannestz.devtoo.presentation

sealed class Screen(val route: String) {
    object ArticleListScreen: Screen("article_list_screen")
    object ArticleDetailScreen: Screen("article_detail_screen")
}
