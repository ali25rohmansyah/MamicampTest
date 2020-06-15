package com.raproject.mamicamptest.view.ui.listBook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.raproject.mamicamptest.R
import com.raproject.mamicamptest.databinding.ActivityListBookBinding
import com.raproject.mamicamptest.view.adapter.AllBookAdapter
import com.raproject.mamicamptest.view.adapter.GenreActionsAdapter
import com.raproject.mamicamptest.view.adapter.GenreRomancesAadapter
import com.raproject.mamicamptest.view.ui.detailBook.DetailBook

class ListBookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBookBinding
    private lateinit var viewModel: ListBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list_book)
        binding.lifecycleOwner = this

        this.viewModel = ViewModelProvider(this).get(ListBookViewModel::class.java)
        binding.viewModel = this.viewModel

//        add action recyclerview
        val viewAdapter = GenreActionsAdapter {item -> showDetail(item)}
        binding.rcAction.adapter = viewAdapter
        viewModel.items.observe(this, Observer { list->
            viewAdapter.submitList(list)
        })

//        add romance recyclerview
        val viewAdapter3 = GenreRomancesAadapter { item -> showDetail(item)}
        binding.rcRomance.adapter = viewAdapter3
        viewModel.items2.observe(this, Observer { list->
            viewAdapter3.submitList(list)
        })

//        add new books recyclerview
        val viewAdapter2 = AllBookAdapter {item -> showDetail(item)}
        binding.rcNewBooks.adapter = viewAdapter2
        viewModel.items2.observe(this, Observer { list->
            viewAdapter2.submitList(list)
        })

        viewModel.response.observe(this, Observer {
            if (it == "1"){
                binding.progressCircular.visibility = View.VISIBLE
                binding.rcAction.visibility = View.GONE
                binding.rcRomance.visibility = View.GONE
                binding.rcNewBooks.visibility = View.GONE
                binding.textView2.visibility = View.GONE
                binding.textView3.visibility = View.GONE
                binding.textView4.visibility = View.GONE
            }else{
                binding.progressCircular.visibility = View.GONE
                binding.rcAction.visibility = View.VISIBLE
                binding.rcRomance.visibility = View.VISIBLE
                binding.rcNewBooks.visibility = View.VISIBLE
                binding.textView2.visibility = View.VISIBLE
                binding.textView3.visibility = View.VISIBLE
                binding.textView4.visibility = View.VISIBLE
            }
        })
    }

    private fun showDetail(id: String) {
        val intent = Intent(this, DetailBook::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }
}