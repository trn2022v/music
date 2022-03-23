package com.example.myapplication.data.network.service.albums

import com.example.myapplication.data.network.model.albums.AlbumsResponse
import com.example.myapplication.data.network.model.artists.ArtistsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumsService {
    companion object {
        private const val BASE_PATH = "2.0"
        private const val KEY_METHOD = "tag.gettopalbums"
        private const val KEY_API_KEY = "a35699f435445486aec22d7a19e652bf"
        private const val KEY_FORMAT = "json"
        private const val TAG = "disco"
    }

    @GET("$BASE_PATH/")
    suspend fun getTopAlbums(
        @Query("method") method: String = KEY_METHOD,
        @Query("limit") limit: Int = 10,
        @Query("tag") tag: String = TAG,
        @Query("api_key") apiKey: String = KEY_API_KEY,
        @Query("format") format: String = KEY_FORMAT,
    ): AlbumsResponse
}