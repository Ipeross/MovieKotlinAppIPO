package com.moviekotlinappipo.network

import com.moviekotlinappipo.models.MovieResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://api.themoviedb.org/3/movie/"
private const val KEY =
    "eeae0c02b09ea56a4b403c847c107843"
private const val LANGUAGE =
    "es-ES"

// https://api.themoviedb.org/3/movie/now_playing?api_key=eeae0c02b09ea56a4b403c847c107843

interface MovieService {
    @GET("now_playing")
    suspend fun listNowPlayingMovies(
        @Query("api_key") apikey : String = KEY,
        @Query("language") language: String = LANGUAGE
    ) : Response<MovieResponse>

}

object MovieServiceFactory {
    fun makeMovieService() : MovieService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }
}