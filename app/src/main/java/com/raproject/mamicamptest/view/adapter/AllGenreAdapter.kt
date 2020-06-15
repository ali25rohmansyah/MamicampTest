package com.raproject.mamicamptest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raproject.mamicamptest.databinding.ItemGenreBinding
import com.raproject.mamicamptest.network.GenreDataResult

class AllGenreAdapter: ListAdapter<GenreDataResult, AllGenreAdapter.AllGenreViewHolder>(DiffCallback){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllGenreViewHolder {
        return AllGenreViewHolder(ItemGenreBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AllGenreViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class AllGenreViewHolder(private val binding: ItemGenreBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(genreDataResult: GenreDataResult){
            binding.item = genreDataResult
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<GenreDataResult>(){
        override fun areItemsTheSame(oldItem: GenreDataResult, newItem: GenreDataResult): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: GenreDataResult, newItem: GenreDataResult): Boolean {
            return  oldItem.id  == newItem.id
        }
    }
}