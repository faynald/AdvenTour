package com.c23pr591.adventour.ui.main.explore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.c23pr591.adventour.R
import com.c23pr591.adventour.core.data.Resource
import com.c23pr591.adventour.core.data.local.DataDummy
import com.c23pr591.adventour.databinding.FragmentExploreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExploreFragment : Fragment(R.layout.fragment_explore) {

    private val binding: FragmentExploreBinding by viewBinding()
    private val viewModel: ExploreViewModel by viewModels()

    private lateinit var recommendationListAdapter: ExploreAdapter
    private lateinit var popularListAdapter: ExploreAdapter
    private lateinit var jawaBaratListAdapter: ExploreAdapter
    private lateinit var jawaTengahListAdapter: ExploreAdapter
    private lateinit var jawaTimurListAdapter: ExploreAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            setupRecyclerView()
            setupObserver()
        }
    }

    private fun setupObserver() {

        // gunung
        viewModel.getAllGunung().observe(viewLifecycleOwner) { gunung ->
            if (gunung != null) {
                when (gunung) {
                    is Resource.Loading -> {
                        Log.e("ExploreFragment", "getAllGunung() Loading . . .")
                    }
                    is Resource.Success -> {
                        recommendationListAdapter.submitList(gunung.data)
                        popularListAdapter.submitList(gunung.data)
                    }
                    is Resource.Error -> {
                        Log.e("ExploreFragment", "getAllGunung() Error")
                    }
                }
            }
        }

        // jawa barat
        viewModel.getAllGunungJawaBarat().observe(viewLifecycleOwner) { gunung ->
            if (gunung != null) {
                when (gunung) {
                    is Resource.Loading -> {
                        Log.e("ExploreFragment", "getAllGunungJawaBarat() Loading . . .")
                    }
                    is Resource.Success -> {
                        jawaBaratListAdapter.submitList(gunung.data)
                    }
                    is Resource.Error -> {
                        Log.e("ExploreFragment", "getAllGunungJawaBarat() Error")
                    }
                }
            }
        }

        // jawa tengah
        viewModel.getAllGunungJawaTengah().observe(viewLifecycleOwner) { gunung ->
            if (gunung != null) {
                when (gunung) {
                    is Resource.Loading -> {
                        Log.e("ExploreFragment", "getAllGunungJawaTengah() Loading . . .")
                    }
                    is Resource.Success -> {
                        jawaTengahListAdapter.submitList(gunung.data)
                    }
                    is Resource.Error -> {
                        Log.e("ExploreFragment", "getAllGunungJawaTengah() Error")
                    }
                }
            }
        }

        // jawa timur
        viewModel.getAllGunungJawaTimur().observe(viewLifecycleOwner) { gunung ->
            if (gunung != null) {
                when (gunung) {
                    is Resource.Loading -> {
                        Log.e("ExploreFragment", "getAllGunungJawaTimur() Loading . . .")
                    }
                    is Resource.Success -> {
                        jawaTimurListAdapter.submitList(gunung.data)
                    }
                    is Resource.Error -> {
                        Log.e("ExploreFragment", "getAllGunungJawaTimur() Error")
                    }
                }
            }
        }

    }

    private fun setupRecyclerView() {

        // recommendation list
        recommendationListAdapter = ExploreAdapter()
        with(binding.rvRecommendation) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = recommendationListAdapter
        }

        // popular list
        popularListAdapter = ExploreAdapter()
        with(binding.rvPopular) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = popularListAdapter
        }

        // jawa barat list
        jawaBaratListAdapter = ExploreAdapter()
        with(binding.rvJawaBarat) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = jawaBaratListAdapter
        }

        // jawa tengah list
        jawaTengahListAdapter = ExploreAdapter()
        with(binding.rvJawaTengah) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = jawaTengahListAdapter
        }

        // jawa timur list
        jawaTimurListAdapter = ExploreAdapter()
        with(binding.rvJawaTimur) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = jawaTimurListAdapter

        }
    }
}