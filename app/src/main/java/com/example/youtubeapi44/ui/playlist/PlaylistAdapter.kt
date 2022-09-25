package com.example.youtubeapi44.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapi44.databinding.ItemListBinding
import com.example.youtubeapi44.data.remote.model.Item

class PlaylistAdapter(
    private var list: List<Item>,
    private val onItemClick: (itemsId: String) -> Unit?
) : RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(var binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(items: Item) {
            Glide.with(binding.root)
                .load(items.snippet.thumbnails.default.url)
                .into(binding.screenshot)
            binding.playlistNameTv.text = items.snippet.title
            binding.playlistCountTv.text =
                items.contentDetails.itemCount.toString() + " video series"
            itemView.setOnClickListener {
                onItemClick(items.id)
            }
        }
    }

}
