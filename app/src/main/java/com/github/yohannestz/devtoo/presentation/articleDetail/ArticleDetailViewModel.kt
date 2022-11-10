package com.github.yohannestz.devtoo.presentation.articleDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.yohannestz.devtoo.common.Constants
import com.github.yohannestz.devtoo.common.Resource
import com.github.yohannestz.devtoo.domain.usecases.getArticle.GetArticleUseCase
import com.github.yohannestz.devtoo.domain.usecases.getArticles.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    private val getArticleUseCase: GetArticleUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(ArticleDetailState())
    val state: State<ArticleDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_ARTICLE_ID)?.let { id ->
            getArticle(id.toInt())
        }
    }

    private fun getArticle(articleId: Int) {
        getArticleUseCase(articleId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ArticleDetailState(article = result.data)
                }

                is Resource.Error -> {
                    _state.value = ArticleDetailState(error = result.message ?: "Unknown error occurred!")
                }

                is Resource.Loading -> {
                    _state.value = ArticleDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}