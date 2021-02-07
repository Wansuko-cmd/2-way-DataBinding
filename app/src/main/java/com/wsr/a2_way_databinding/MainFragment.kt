package com.wsr.a2_way_databinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.wsr.a2_way_databinding.databinding.FragmentMainBinding
import com.wsr.a2_way_databinding.databinding.RecyclerviewBinding

class MainFragment : Fragment() {

    private lateinit var binding: RecyclerviewBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecyclerviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        binding.lifecycleOwner = this

        val dataBindingViewController = DataBindingViewController(viewModel)

        binding.recyclerView.apply{
            this.adapter = dataBindingViewController.adapter
            this.layoutManager = LinearLayoutManager(requireContext()).apply{
                orientation = LinearLayoutManager.VERTICAL
            }
        }

        dataBindingViewController.setData(viewModel)

        /*binding.viewModel = viewModel

        viewModel.map.postValue(mutableMapOf("" to "Test"))

        binding.key = ""

        binding.editView.addTextChangedListener{ value ->
            value?.let{
                viewModel.map.postValue(mutableMapOf("" to it.toString()))
            }
        }*/
    }
}