package com.practice.retrofit

import android.util.Log
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception
import javax.security.auth.callback.Callback

class ViewModelfile :ViewModel() {
//    private val viewModelJob = Job()
//    private val coroutineScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private val _details = MutableLiveData<List<CountryDetails>>()
    val values: LiveData<List<CountryDetails>>
        get() = _details

    init {
//        _details.value = null
        getCountryDetails()
    }

    private fun getCountryDetails() {

        CountryApi.retrofitService.getProperties().enqueue(object :retrofit2.Callback<List<CountryDetails>>{
            override fun onFailure(call: Call<List<CountryDetails>>, t: Throwable) {
                    Log.i("ViewModel","Failed")
            }

            override fun onResponse(call: Call<List<CountryDetails>>, response: Response<List<CountryDetails>>) {
                _details.value = response.body()

            }



        })




//        coroutineScope.launch {
//            val listDetails = CountryApi.retrofitService.getProperties()
//            if (listDetails.size > 0) {
//                _details.value = listDetails
//
//            }
//        }
    }
}