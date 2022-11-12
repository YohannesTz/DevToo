package com.github.yohannestz.devtoo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.yohannestz.devtoo.presentation.articleDetail.ArticleDetailScreen
import com.github.yohannestz.devtoo.presentation.articleList.ArticleListScreen
import com.github.yohannestz.devtoo.ui.theme.DevTooTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevTooTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text("DevToo", fontWeight = FontWeight.Black)
                            }
                        )
                    }
                ) {
                    Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.padding(it)) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = Screen.ArticleListScreen.route) {
                            composable(
                                route = Screen.ArticleListScreen.route
                            ) {
                                ArticleListScreen(navController)
                            }

                            composable(
                                route = Screen.ArticleDetailScreen.route + "/{articleId}"
                            ) {
                                ArticleDetailScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DevTooTheme {
        Greeting("Android")
    }
}