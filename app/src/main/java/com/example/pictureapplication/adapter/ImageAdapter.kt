package com.example.pictureapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pictureapplication.databinding.ItemImageBinding
import com.example.pictureapplication.model.PhoneModel
import com.example.pictureapplication.model.Pixaboy

class ImageAdapter(val item: List<Pixaboy>) : RecyclerView.Adapter<ImageAdapter.ItemHolder>() {
    class ItemHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val items = item[position]


        holder.binding.tvImage.text = items.tags
        Glide.with(holder.itemView.context).load(items.previewURL).into(holder.binding.ivImage)
    }

    override fun getItemCount(): Int {
        return item.size
    }
}