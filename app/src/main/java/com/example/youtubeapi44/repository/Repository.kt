package com.example.youtubeapi44.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeapi44.BuildConfig
import com.example.youtubeapi44.data.remote.model.Playlists
import com.example.youtubeapi44.data.remote.ApiService
import com.example.youtubeapi44.core.network.RetrofitClient
import com.example.youtubeapi44.core.network.result.Resource
import com.example.youtubeapi44.data.remote.model.Item
import com.example.youtubeapi44.utils.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlaylists(): LiveData<Resource<Playlists>> {

        val data = MutableLiveData<Resource<Playlists>>()
        data.value = Resource.loading(null)
        apiService.getPlaylists(Const.channelId, Const.part, BuildConfig.API_KEY, Const.maxResult)
            .enqueue(object :
                Callback<Playlists> {
                override fun onResponse(call: Call<Playlists>, response: Response<Playlists>) {
                    if (response.isSuccessful) {
                        data.value = Resource.success(response.body())
                    }
                }

                override fun onFailure(call: Call<Playlists>, t: Throwable) {
                    data.value = Resource.error(null, t.message, null)
                }

            })
        return data
    }


}