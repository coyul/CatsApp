package com.coyul.catsapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coyul.catsapp.R
import com.coyul.catsapp.databinding.CatListItemBinding
import com.coyul.catsapp.presentation.model.Cat

class CatsAdapter : ListAdapter<Cat, CatsAdapter.ViewHolder>(CatDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CatListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindView(currentList[position])

    class ViewHolder(
        private val binding: CatListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: Cat) {
            binding.title.text = item.name
            binding.description.text = item.description
            Glide
                .with(itemView)
                .load(item.imageUrl)
                .centerCrop()
                .placeholder(R.drawable.ic_stub_image)
                .into(binding.image)
        }
    }

    private class CatDiffCallBack : DiffUtil.ItemCallback<Cat>() {
        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean =
            oldItem.description == newItem.description && oldItem.name == newItem.name && oldItem.imageUrl == newItem.imageUrl
    }
}