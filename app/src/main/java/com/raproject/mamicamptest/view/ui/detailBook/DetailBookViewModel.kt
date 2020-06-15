package com.raproject.mamicamptest.view.ui.detailBook

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.raproject.mamicamptest.network.DetailBookDataResult
import com.raproject.mamicamptest.network.DetailUserData
import com.raproject.mamicamptest.network.DetailUserDataResult
import com.raproject.mamicamptest.network.cabacaApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DetailBookViewModel(id:String, application: Application): AndroidViewModel(application) {

    private var _response = MutableLiveData<String>()
    private val _item = MutableLiveData<DetailBookDataResult>()
    private val _itemUser = MutableLiveData<DetailUserDataResult>()

    val response: MutableLiveData<String>
        get() = _response
    val item : LiveData<DetailBookDataResult>
        get() = _item

    val itemUser : LiveData<DetailUserDataResult>
        get() = _itemUser

    private val vmJob = Job()
    private val crScope = CoroutineScope(vmJob + Dispatchers.Main)

    init {
        crScope.launch {
            try {
                _response.postValue("1")

                val result = cabacaApi.retrofitServic.showDetailBook(id)
                _item.postValue(result.result)

                val resultUser = cabacaApi.retrofitServic.showDetailUser("416")
                _itemUser.postValue(resultUser.result)

                _response.postValue("2")

            }catch (t: Throwable){
                Log.d("debug", "error = ${t.message}")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        vmJob.cancel()
    }
}