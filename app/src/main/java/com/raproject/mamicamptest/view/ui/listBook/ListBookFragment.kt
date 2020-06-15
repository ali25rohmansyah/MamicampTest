package com.raproject.mamicamptest.view.ui.listBook

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.raproject.mamicamptest.BaseActivity
import com.raproject.mamicamptest.databinding.FragmentListBookBinding
import com.raproject.mamicamptest.view.adapter.AllBookAdapter
import com.raproject.mamicamptest.view.adapter.GenreActionsAdapter
import com.raproject.mamicamptest.view.ui.detailBook.DetailBook

class ListBookFragment : Fragment() {

    private lateinit var binding: FragmentListBookBinding
    private lateinit var viewModel: ListBookViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(ListBookViewModel::class.java)
        binding = FragmentListBookBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

//        add recyclervier
        val viewAdapter = GenreActionsAdapter {item -> showDetail(item)}
        binding.rcAction.adapter = viewAdapter

        viewModel.items.observe(viewLifecycleOwner, Observer { list->
            viewAdapter.submitList(list)
        })

//        add recyclervier
        val viewAdapter2 = AllBookAdapter {item -> showDetail(item)}

        binding.rcNewBooks.adapter = viewAdapter2

        viewModel.items2.observe(viewLifecycleOwner, Observer { list->
            viewAdapter2.submitList(list)
        })

        return binding.root
    }

    private fun showDetail(id: String) {
        val intent = Intent(activity, DetailBook::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}