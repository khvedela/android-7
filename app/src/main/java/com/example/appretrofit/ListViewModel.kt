package com.example.appretrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appretrofit.models.allUsers.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val countryLiveData = MutableLiveData<List<Data?>>().apply {
        mutableListOf<Data>()
    }

    val _countryLiveData: LiveData<List<Data?>> = countryLiveData

    private val loadingLiveData = MutableLiveData<Boolean>()
    val _loadingLiveData:LiveData<Boolean> = loadingLiveData.apply {
        true
    }

    fun init() {
        CoroutineScope(Dispatchers.IO).launch {
            getCountries()
        }
    }


    private suspend fun getCountries() {
        loadingLiveData.postValue(true)
        val result = RetrofitService.service().getAllUsers()

        if (result.isSuccessful) {
            val items = result.body()
            countryLiveData.postValue(items?.data)
        }
        loadingLiveData.postValue(false)
    }

}