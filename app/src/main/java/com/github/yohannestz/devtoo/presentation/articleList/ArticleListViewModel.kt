package com.github.yohannestz.devtoo.presentation.articleList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yohannestz.devtoo.common.Resource
import com.github.yohannestz.devtoo.domain.usecases.getArticles.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase
): ViewModel() {

    private val _state = mutableStateOf(ArticleListState())
    val state: State<ArticleListState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        getArticlesUseCase(1, 20).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ArticleListState(articles = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = ArticleListState(error = result.message ?: "Unknown error occurred!")
                }

                is Resource.Loading -> {
                    _state.value = ArticleListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}