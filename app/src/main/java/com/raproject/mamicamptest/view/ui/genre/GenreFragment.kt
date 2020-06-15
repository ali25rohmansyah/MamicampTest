package com.raproject.mamicamptest.view.ui.genre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.raproject.mamicamptest.R

class GenreFragment : Fragment() {

    private lateinit var genreViewModel: GenreViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        genreViewModel =
            ViewModelProviders.of(this).get(GenreViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_genre, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        genreViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}