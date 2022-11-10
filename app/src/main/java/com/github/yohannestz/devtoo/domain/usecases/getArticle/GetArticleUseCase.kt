package com.github.yohannestz.devtoo.domain.usecases.getArticle

import com.github.yohannestz.devtoo.common.Resource
import com.github.yohannestz.devtoo.data.remote.dto.toArticleDetail
import com.github.yohannestz.devtoo.domain.models.Article
import com.github.yohannestz.devtoo.domain.models.ArticleDetail
import com.github.yohannestz.devtoo.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetArticleUseCase @Inject constructor(
    private val repository: ArticleRepository
) {
    operator fun invoke(articleId: Int): Flow<Resource<ArticleDetail>> = flow {
        try {
            emit(Resource.Loading())
            val article = repository.getArticleById(articleId).toArticleDetail()
            emit(Resource.Success(article))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unexpected error!"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server check your connection!"))
        }
    }
}