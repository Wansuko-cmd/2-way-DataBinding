package com.wsr.a2_way_databinding

import androidx.databinding.adapters.TextViewBindingAdapter
import com.airbnb.epoxy.TypedEpoxyController

class DataBindingViewController(private val viewModel: MainViewModel) : TypedEpoxyController<MainViewModel>(){
    override fun buildModels(data: MainViewModel?) {
        fragmentMain {
            id(modelCountBuiltSoFar)
            viewModel(viewModel)
        }
    }
}