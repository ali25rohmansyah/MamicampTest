package com.raproject.mamicamptest.view.ui.listBook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.raproject.mamicamptest.databinding.FragmentListBookBinding
import com.raproject.mamicamptest.view.adapter.AllBookAdapter
import com.raproject.mamicamptest.view.adapter.GenreActionsAdapter

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
        val viewAdapter = GenreActionsAdapter ()
        binding.rcAction.adapter = viewAdapter

        viewModel.items.observe(viewLifecycleOwner, Observer { list->
            viewAdapter.submitList(list)
        })

//        add recyclervier
        val viewAdapter2 = AllBookAdapter ()
        binding.rcAction.adapter = viewAdapter

        viewModel.items2.observe(viewLifecycleOwner, Observer { list->
            viewAdapter.submitList(list)
        })

        return binding.root
    }
}