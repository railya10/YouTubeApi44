package com.example.youtubeapi44.core.network.result

import com.example.youtubeapi44.data.remote.model.Item
import com.example.youtubeapi44.data.remote.model.Playlists


data class Resource<out T>(val status: Status, val data: T?, val message: String?, val code: Int?) {
    companion object {
        fun <T> success(data: T?, code: Int? = null): Resource<Playlists>? {
            return Resource(Status.SUCCESS, data, null, code)
        }

        fun <T> error(data: T?, msg: String?, code: Int? = null): Resource<T> {
            return Resource(Status.ERROR, data, msg, code)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null, null)
        }
    }
}