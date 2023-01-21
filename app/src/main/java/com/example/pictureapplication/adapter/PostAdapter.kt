package com.example.pictureapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pictureapplication.R
import com.example.pictureapplication.databinding.ItemPersonBinding
import com.example.pictureapplication.databinding.ItemPostBinding
import com.example.pictureapplication.model.PostModel

class PostAdapter(val item:List<PostModel>):RecyclerView.Adapter<PostAdapter.ItemHolder>() {
    class ItemHolder(val binding: ItemPostBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ItemPostBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val items = item[position]
        holder.binding.ivPost.text = items.text

        Glide.with(holder.itemView.context).load(items.image)
            .placeholder(R.drawable.back).into(holder.binding.ivPostImage)
    }
    override fun getItemCount(): Int {
        return item.size
    }
}