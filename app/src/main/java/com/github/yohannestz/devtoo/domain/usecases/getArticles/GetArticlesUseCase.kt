package com.github.yohannestz.devtoo.domain.usecases.getArticles

import android.util.Log
import com.github.yohannestz.devtoo.common.Resource
import com.github.yohannestz.devtoo.data.remote.dto.toArticle
import com.github.yohannestz.devtoo.domain.models.Article
import com.github.yohannestz.devtoo.domain.repository.ArticleRepository
import com.github.yohannestz.devtoo.pagination.DefaultPaginator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(
    private val repository: ArticleRepository
) {

    operator fun invoke(page: Int, perPage: Int): Flow<Resource<List<Article>>> = flow {

        try {
            emit(Resource.Loading())
            val articles = repository.getArticles(page, perPage).map { it.toArticle() }
            Log.e("articles", articles.toString())
            emit(Resource.Success(articles))
        } catch (e: HttpException) {
            Log.e("httpExp", e.toString())
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected error!"))
        } catch (e: IOException) {
            Log.e("ioExp", e.toString())
            emit(Resource.Error(message = "Couldn't reach server check your connection!"))
        }
    }
}