package com.raproject.mamicamptest.view.ui.detailBook

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailBookViewModelFactory(private val id: String, private val application: Application): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  DetailBookViewModel(id, application) as T
    }

}