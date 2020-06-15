package com.raproject.mamicamptest.view.ui.genre

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raproject.mamicamptest.network.BookDataResult
import com.raproject.mamicamptest.network.GenreData
import com.raproject.mamicamptest.network.GenreDataResult
import com.raproject.mamicamptest.network.cabacaApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class GenreViewModel : ViewModel() {

    private var _response = MutableLiveData<String>()
    private var _items = MutableLiveData<List<GenreDataResult>>()


    val response: MutableLiveData<String>
        get() = _response
    val items: LiveData<List<GenreDataResult>>
        get() = _items

    private val vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init{
        crScope.launch {
            _response.value = "1"
            try {
                val result = cabacaApi.retrofitServic.showAllGenre()

                if (result.result.isNotEmpty()) {
                    _items.value = result.result
                    _response.postValue("2")
                }

            }catch (t: Throwable){
                Log.d("error", t.message.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}