package com.practice.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET



private  const val BASE_URL ="https://restcountries.eu/rest/v2/"

private  val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
//        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL).build()

interface RestAPI {

    @GET("all")
    fun  getProperties():
            Call<List<CountryDetails>>
//            List<CountryDetails>
 }

object  CountryApi{
    val retrofitService :RestAPI by lazy { retrofit.create(RestAPI::class.java) }
}