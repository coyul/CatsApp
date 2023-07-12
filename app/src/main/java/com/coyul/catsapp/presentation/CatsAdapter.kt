package com.coyul.catsapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coyul.catsapp.R
import com.coyul.catsapp.databinding.CatListItemBinding

class CatsAdapter : RecyclerView.Adapter<CatsAdapter.ViewHolder>() {

    private var catsList: List<Cat> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CatListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = catsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindView(catsList[position])

    fun submitList(list: List<Cat>) {
        this.catsList = list
        notifyItemRangeChanged(0, catsList.size - 1)
    }

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
}