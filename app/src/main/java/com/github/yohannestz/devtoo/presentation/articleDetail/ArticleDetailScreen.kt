@file:OptIn(ExperimentalMaterial3Api::class)

package com.github.yohannestz.devtoo.presentation.articleDetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.google.accompanist.flowlayout.FlowRow
import dev.jeziellago.compose.markdowntext.MarkdownText

@Composable
fun ArticleDetailScreen(
    viewModel: ArticleDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier
        .fillMaxSize()) {
        state.article?.let { articleDetail ->
            LazyColumn(modifier = Modifier
                .fillMaxSize(), contentPadding = PaddingValues(20.dp)) {
                item {
                    AsyncImage(
                        model = articleDetail.coverImage,
                        contentDescription = "UserImage",
                        contentScale = ContentScale.Crop
                    )

                    Box(modifier = Modifier.padding(top = 8.dp)) {
                        articleDetail.title?.let {
                            Text(
                                it,
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp
                            )
                        }
                    }

                    Box(modifier = Modifier.padding(top = 8.dp)) {
                        articleDetail.user?.name.let {
                            Text(text = it.toString())
                        }
                    }

                    Box(modifier = Modifier.padding(top = 8.dp)) {
                        articleDetail.tagsList?.let {
                            Text(
                                it
                            )
                        }
                    }

                    Box(modifier = Modifier.padding(top = 8.dp)) {
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