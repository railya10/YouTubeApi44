package com.example.youtubeapi44.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi44.BuildConfig
import com.example.youtubeapi44.`object`.Constant
import com.example.youtubeapi44.core.ui.BaseViewModel
import com.example.youtubeapi44.data.remote.ApiService
import com.example.youtubeapi44.core.network.RetrofitClient
import com.example.youtubeapi44.data.remote.model.Playlists
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : BaseViewModel() {

    private val apiService : ApiService by lazy {
        RetrofitClient.create()
    }

    fun playlists():LiveData<Playlists> {
        return getPlaylists()
    }

    private fun getPlaylists ():LiveData<Playlists> {

        val data = MutableLiveData<Playlists>()

        apiService.getPlaylists(Constant.channelId, Constant.part, BuildConfig.API_KEY).enqueue(object : Callback<Playlists>{
            override fun onResponse(call: Call<Playlists>, response: Response<Playlists>) {
                if (response.isSuccessful)
                    data.value = response.body()
            }

            override fun onFailure(call: Call<Playlists>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return data

    }
}