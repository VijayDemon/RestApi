package com.practice.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.practice.retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding :ActivityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(ViewModelfile::class.java)
        binding.setLifecycleOwner(this)
        binding.viewModel=viewModel

        viewModel.values.observe(this, Observer {
             binding.recView.adapter = BindAdapter(it)
         })
     }
}
