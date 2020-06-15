package com.raproject.mamicamptest.view.ui.detailBook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.raproject.mamicamptest.R
import com.raproject.mamicamptest.databinding.ActivityDetailBookBinding

class DetailBook : AppCompatActivity() {

    private lateinit var binding:ActivityDetailBookBinding
    private lateinit var viewModel: DetailBookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_book)
        binding.lifecycleOwner = this

//        get id
        val id = intent.getStringExtra("id")
        val vmfactory = DetailBookViewModelFactory(id!!, this.application)
        this.viewModel = ViewModelProvider(this, vmfactory).get(DetailBookViewModel::class.java)
        binding.viewModel = this.viewModel
    }
}