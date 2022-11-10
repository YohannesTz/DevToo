@file:OptIn(ExperimentalMaterial3Api::class)

package com.github.yohannestz.devtoo.presentation.articleList.compontents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.github.yohannestz.devtoo.domain.models.Article
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun ArticleListItem(
    article: Article,
    onItemClick: (Article) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { onItemClick(article) },
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(article) }
                .padding(20.dp),
        ) {
            Row {
                AsyncImage(
                    model = article.user?.profile_image,
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
                    article.user?.let { Text(text = it.name) }
                    article.publishedTimeStamp?.let { Text(text = it) }
                }
            }

            Box(modifier = Modifier.padding(top = 8.dp)) {
                article.title?.let {
                    Text(
                        it,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }
            }

            Box(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
                article.description?.let {
                    Text(
                        text = it
                    )
                }
            }

            Box(modifier = Modifier.padding(top = 0.dp, bottom = 0.dp)) {
                FlowRow(
                    mainAxisSpacing = 8.dp,
                    crossAxisSpacing = 2.dp,
                ) {
                    article.tagList?.forEach { tag ->
                        AssistChip(
                            onClick = { /* Do something! */ },
                            label = {
                                Text(tag)
                            },
                            shape = RoundedCornerShape(16.dp)
                        )
                    }
                }
            }
        }
    }
}