package com.c23pr591.adventour.ui.main.explore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.c23pr591.adventour.R
import com.c23pr591.adventour.core.data.Resource
import com.c23pr591.adventour.core.data.local.DataDummy
import com.c23pr591.adventour.databinding.FragmentExploreBinding

class ExploreFragment : Fragment(R.layout.fragment_explore) {

    private val binding: FragmentExploreBinding by viewBinding()
    private val viewModel: ExploreViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            // recommendation list
            val recommendationListAdapter = ExploreAdapter()
            with(binding.rvRecommendation) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = recommendationListAdapter
            }
            recommendationListAdapter.submitList(DataDummy.generateGunungList())

            // popular list
            val popularListAdapter = ExploreAdapter()
            with(binding.rvPopular) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = popularListAdapter
            }
            popularListAdapter.submitList(DataDummy.generateGunungList())

            // jawa barat list
            val jawaBaratListAdapter = ExploreAdapter()
            with(binding.rvJawaBarat) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = popularListAdapter
            }
            jawaBaratListAdapter.submitList(DataDummy.generateGunungList())

            // jawa tengah list
            val jawaTengahListAdapter = ExploreAdapter()
            with(binding.rvJawaTengah) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = popularListAdapter
            }
            jawaTengahListAdapter.submitList(DataDummy.generateGunungList())

            // jawa timur list
            val jawaTimurListAdapter = ExploreAdapter()
            with(binding.rvJawaTimur) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
                adapter = popularListAdapter
            }
            jawaTimurListAdapter.submitList(DataDummy.generateGunungList())

//            viewModel.getAllGunung().observe(viewLifecycleOwner) { gunung ->
//                if (gunung != null) {
//                    when (gunung) {
//                        is Resource.Loading -> {
//
//                        }
//                        is Resource.Success -> {
//
//                        }
//                        is Resource.Error -> {
//
//                        }
//                    }
//                }
//            }
        }
    }
}