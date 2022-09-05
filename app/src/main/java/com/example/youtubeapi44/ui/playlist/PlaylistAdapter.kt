package com.example.youtubeapi44.ui.playlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeapi44.databinding.ItemListBinding
import com.example.youtubeapi44.model.Item

class PlaylistAdapter(private val list:List<Item>, private val onItemClick: (itemsId: String) -> Unit?): RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    lateinit var binding: ItemListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int  = list.size

    inner class ViewHolder(itemView: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun onBind(items: Item) {
            Glide.with(binding.root)
                .load(items.snippet.thumbnails.default.url)
                .into(binding.screenshot)
            binding.playlistNameTv.text = items.snippet.title
            binding.playlistCountTv.text = items.contentDetails.itemCount.toString() + " video series"
            itemView.setOnClickListener{
                onItemClick(items.id)
            }
        }
    }

}
