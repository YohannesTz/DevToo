package com.github.yohannestz.devtoo.pagination

interface Paginator<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}
