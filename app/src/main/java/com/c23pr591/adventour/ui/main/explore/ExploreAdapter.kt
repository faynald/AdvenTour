package com.c23pr591.adventour.ui.main.explore

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.c23pr591.adventour.core.domain.model.Gunung
import com.c23pr591.adventour.databinding.ItemRecommendationBinding

class ExploreAdapter : ListAdapter<Gunung, ExploreAdapter.ItemViewholder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder =
        ItemViewholder(
            ItemRecommendationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: ExploreAdapter.ItemViewholder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewholder(private val binding: ItemRecommendationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Gunung) = with(binding) {
            Glide.with(itemView)
                .load("https://upload.wikimedia.org/wikipedia/commons/1/12/Semeru.jpg")
                .into(itemImg)
            itemLocation.text = item.lokasi
            itemName.text = item.nama
            itemRating.rating = item.rating?.toFloat() ?: 0F
            itemTvRating.text = item.rating.toString()

            root.setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Gunung>() {
    override fun areItemsTheSame(oldItem: Gunung, newItem: Gunung): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Gunung, newItem: Gunung): Boolean {
        return oldItem == newItem
    }
}