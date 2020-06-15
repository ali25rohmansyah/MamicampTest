package com.raproject.mamicamptest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raproject.mamicamptest.databinding.ItemBooksBinding
import com.raproject.mamicamptest.network.BookDataResult

class GenreActionsAdapter: ListAdapter<BookDataResult, GenreActionsAdapter.ActionsViewHolder>(DiffCallback){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionsViewHolder {
        return ActionsViewHolder(ItemBooksBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ActionsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ActionsViewHolder(private val binding: ItemBooksBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(bookDataResult: BookDataResult){
            binding.item = bookDataResult
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<BookDataResult>(){
        override fun areItemsTheSame(oldItem: BookDataResult, newItem: BookDataResult): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: BookDataResult, newItem: BookDataResult): Boolean {
            return  oldItem.id  == newItem.id
        }
    }
}