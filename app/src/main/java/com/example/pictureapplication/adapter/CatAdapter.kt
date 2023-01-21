package com.example.pictureapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pictureapplication.R
import com.example.pictureapplication.databinding.ItemPersonBinding
import com.example.pictureapplication.model.Model

interface UserListener{
    fun onClick(item: Model)
}
class CatAdapter(val item: List<Model>,val listener:UserListener): RecyclerView.Adapter<CatAdapter.ItemHolder>() {
    class ItemHolder(val binding: ItemPersonBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ItemPersonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val items = item[position]
        holder.itemView.setOnClickListener {
           listener.onClick(items)
        }


        holder.binding.tvCat.text = items.firstName
        Glide.with(holder.itemView.context).load(items.picture)
            .placeholder(R.drawable.back).into(holder.binding.ivCat)
    }

    override fun getItemCount(): Int {
        return item.size
    }
}