package com.moviekotlinappipo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.moviekotlinappipo.models.Result


@Composable
fun CustomTileComponent(movie : Result) {
    Card {
        Column {
            AsyncImage(
                model= "https://image.tmdb.org/t/p/w500${movie.poster_path}",
                contentDescription = movie.title
            )
            Text(
                text = movie.title
            )
        }
    }
}