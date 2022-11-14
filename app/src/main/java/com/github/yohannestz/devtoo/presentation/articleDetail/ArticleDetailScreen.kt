@file:OptIn(ExperimentalMaterial3Api::class)

package com.github.yohannestz.devtoo.presentation.articleDetail

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import dev.jeziellago.compose.markdowntext.MarkdownText

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun ArticleDetailScreen(
    viewModel: ArticleDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier
        .fillMaxSize()) {
        state.article?.let { articleDetail ->
            LazyColumn(modifier = Modifier
                .fillMaxSize(), contentPadding = PaddingValues(0.dp)) {
                item {
                    AsyncImage(
                        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                        model = articleDetail.coverImage,
                        contentDescription = "CoverImage",
                        contentScale = ContentScale.Crop
                    )

                    Row (modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 20.dp, end = 20.dp)){
                        AsyncImage(
                            model = articleDetail.user?.profile_image,
                            contentDescription = "UserImage",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(45.dp)
                                .clip(CircleShape)
                        )

                        Column(
                            modifier = Modifier
                                .padding(start = 8.dp)
                        ) {
                            articleDetail.user?.let { Text(text = it.name) }
                            articleDetail.readablePublishDate?.let { Text(text = it) }
                        }
                    }

                    Log.e("coverImage", articleDetail.coverImage.toString())

                    Box(modifier = Modifier.padding(top = 8.dp, start = 20.dp, end = 20.dp)) {
                        articleDetail.title?.let {
                            Text(
                                it,
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            )
                        }
                    }

                    Box(modifier = Modifier.padding(top = 8.dp, start = 20.dp, end = 20.dp)) {
                        articleDetail.user?.name.let {
                            Text(
                                text = it.toString(),
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }

                    Box(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 20.dp, end = 20.dp)) {
                        articleDetail.tagsList?.let {
                            Text(
                                it
                            )
                        }
                    }

                    Box(modifier = Modifier.padding(top = 8.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)) {
                        articleDetail.bodyMarkDown?.let {
                            MarkdownText(markdown = it)
                        }
                    }
                }
            }
        }

        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}