package com.raproject.mamicamptest.view.ui.genre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.raproject.mamicamptest.databinding.FragmentGenreBinding
import com.raproject.mamicamptest.view.adapter.AllBookAdapter
import com.raproject.mamicamptest.view.adapter.AllGenreAdapter

class GenreFragment : Fragment() {

    private lateinit var binding: FragmentGenreBinding
    private lateinit var viewModel: GenreViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(GenreViewModel::class.java)
        binding = FragmentGenreBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

//        Add recyclerview
        val viewAdapter = AllGenreAdapter ()
        binding.rcGenre.adapter = viewAdapter

        viewModel.items.observe(viewLifecycleOwner, Observer { list->
            viewAdapter.submitList(list)
        })

        return binding.root
    }
}