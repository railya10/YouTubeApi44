package com.example.youtubeapi44.ui.playlist_details

import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeapi44.base.BaseActivity
import com.example.youtubeapi44.databinding.ActivityPlaylistDetailsBinding
import com.example.youtubeapi44.ui.playlist.PlaylistActivity

class PlaylistDetailsActivity() : BaseActivity <PlaylistDetailsViewModel, ActivityPlaylistDetailsBinding>() {

    override val viewModel: PlaylistDetailsViewModel by lazy {
        ViewModelProvider(this)[PlaylistDetailsViewModel::class.java]
    }


    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistDetailsBinding {
        return ActivityPlaylistDetailsBinding.inflate(inflater)
    }
    override fun initView() {
        val channelId = intent.getStringExtra(PlaylistActivity.KEY)
        Toast.makeText(this, channelId, Toast.LENGTH_SHORT).show()
    }

}