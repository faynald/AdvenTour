package com.c23pr591.adventour.ui.detail

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.c23pr591.adventour.core.domain.model.FeedbackItem
import com.c23pr591.adventour.databinding.ItemReviewBinding

class ReviewAdapter : ListAdapter<FeedbackItem, ReviewAdapter.ItemViewholder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder =
        ItemViewholder(
            ItemReviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: ReviewAdapter.ItemViewholder, position: Int) {
        holder.bind(getItem(position))
    }

    class ItemViewholder(private val binding: ItemReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FeedbackItem) = with(binding) {
            Log.e("ReviewAdapter", item.toString())
            val profileImageUrl = "https://t4.ftcdn.net/jpg/01/18/03/35/360_F_118033506_uMrhnrjBWBxVE9sYGTgBht8S5liVnIeY.jpg"
            Glide.with(itemView.context)
                .load(profileImageUrl)
                .into(itemImgProfile)
            itemTvUsername.text = item.user?.nama
            itemTvRating.text = item.rating.toString()
            itemRatingBar.rating = item.rating?.toFloat() ?: 0F
            itemTvReview.text = item.review
            itemTvUserLocation.text = item.user?.domisili

            root.setOnClickListener {
                // TODO: Handle on click
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<FeedbackItem>() {
    override fun areItemsTheSame(oldItem: FeedbackItem, newItem: FeedbackItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: FeedbackItem, newItem: FeedbackItem): Boolean {
        return oldItem == newItem
    }
}