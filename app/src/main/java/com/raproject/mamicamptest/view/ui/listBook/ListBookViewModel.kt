package com.raproject.mamicamptest.view.ui.listBook

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raproject.mamicamptest.network.BookDataResult
import com.raproject.mamicamptest.network.cabacaApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ListBookViewModel : ViewModel() {

    private var _response = MutableLiveData<String>()
    private var _items = MutableLiveData<List<BookDataResult>>()
    private var _items2 = MutableLiveData<List<BookDataResult>> ()
    private var _items3 = MutableLiveData<List<BookDataResult>>()


    val response: MutableLiveData<String>
        get() = _response
    val items: LiveData<List<BookDataResult>>
        get() = _items
    val items2: LiveData<List<BookDataResult>>
        get() = _items2
    val items3: LiveData<List<BookDataResult>>
        get() = _items3

    private val vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init{
        _response.value = "1"
        crScope.launch {
            _response.value = "1"
            try {
                val result = cabacaApi.retrofitServic.showActions()
                val result2 = cabacaApi.retrofitServic.showUpdateBook()
                val result3 = cabacaApi.retrofitServic.showRomance()

                if (result.results.isNotEmpty() || result2.results.isNotEmpty() || result3.results.isNotEmpty()) {
                    _items.value = result.results
                    _items2.value = result2.results
                    _items3.value = result3.results
                    _response.postValue("2")
                }else{
                    _response.postValue("1")
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