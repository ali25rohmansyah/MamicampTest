package com.raproject.mamicamptest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raproject.mamicamptest.databinding.ItemBooksBinding
import com.raproject.mamicamptest.network.BookDataResult

class GenreRomancesAadapter (private val showDetail: (String) -> Unit): ListAdapter<BookDataResult, GenreRomancesAadapter.RomancesViewHolder>(DiffCallback){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RomancesViewHolder {
        return RomancesViewHolder(ItemBooksBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RomancesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class RomancesViewHolder(private val binding: ItemBooksBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(bookDataResult: BookDataResult){
            binding.cardView.setOnClickListener{
                showDetail(binding.txtId.text.toString())
            }
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