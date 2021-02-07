package com.wsr.a2_way_databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel() : ViewModel(){
    val map = MutableLiveData<MutableMap<String, String>>()
    val text = MutableLiveData<String>()
}