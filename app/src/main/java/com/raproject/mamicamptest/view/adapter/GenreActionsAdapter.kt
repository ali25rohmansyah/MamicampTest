package com.raproject.mamicamptest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.raproject.mamicamptest.databinding.ItemGenreActionsBinding
import com.raproject.mamicamptest.network.ActionDataResult

class GenreActionsAdapter: ListAdapter<ActionDataResult, GenreActionsAdapter.ActionsViewHolder>(DiffCallback){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionsViewHolder {
        return ActionsViewHolder(ItemGenreActionsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ActionsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ActionsViewHolder(private val binding: ItemGenreActionsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(actionDataResult: ActionDataResult){
            binding.item = actionDataResult
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<ActionDataResult>(){
        override fun areItemsTheSame(oldItem: ActionDataResult, newItem: ActionDataResult): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ActionDataResult, newItem: ActionDataResult): Boolean {
            return  oldItem.id  == newItem.id
        }
    }
}