package com.example.youtubeapi44.data.remote

import com.example.youtubeapi44.data.remote.model.Playlists
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlaylists(
        @Query ("channelId") channelId : String,
        @Query ("part") part : String,
        @Query ("key") apiKey : String,
        @Query ("maxResults") maxResults : Int = 50

    ) : Call <Playlists>
}