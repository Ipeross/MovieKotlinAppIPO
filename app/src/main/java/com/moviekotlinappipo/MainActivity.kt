package com.moviekotlinappipo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moviekotlinappipo.components.CustomTileComponent
import com.moviekotlinappipo.network.MovieServiceFactory
import com.moviekotlinappipo.models.Result

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = MovieServiceFactory.makeMovieService()

        enableEdgeToEdge()

            setContent {
                var moviesList by remember { mutableStateOf<List<Result>>(emptyList()) }

                LaunchedEffect(Unit) {
                    try {
                        val response = service.listNowPlayingMovies()
                        if (response.isSuccessful) {
                            moviesList = response.body()?.results ?: emptyList()
                        } else {
                            println("API Error, cannot load movies")
                        }
                    } catch (ex: Exception) {
                        println("API Error: $ex")
                    }
                }

                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Películas en Cartelera",
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(50.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(50.dp)
                    ) {
                        items(moviesList) { movie ->
                            CustomTileComponent(movie = movie)
                        }
                    }
                }
            }
        }
    }

