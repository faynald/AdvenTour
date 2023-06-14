package com.c23pr591.adventour.ui.main.whistlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.c23pr591.adventour.R
import com.c23pr591.adventour.databinding.FragmentWhistlistBinding
import com.c23pr591.adventour.ui.main.explore.ExploreAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WhistlistFragment : Fragment(R.layout.fragment_whistlist) {

    private val binding: FragmentWhistlistBinding by viewBinding()
    private val viewModel: WhistlistViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            // recommendation list
            val whistlistAdapter = WhistlistAdapter()
            with(binding.recyclerView) {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                adapter = whistlistAdapter
            }
            viewModel.getAllWhistlist().observe(viewLifecycleOwner) { whistlist ->
                if (whistlist.isNotEmpty()) {
                    whistlistAdapter.submitList(whistlist)
                    binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            if (query != null) {
                                val dataFiltered = whistlist.filter { it.nama!!.lowercase().contains(query.lowercase())}
                                whistlistAdapter.submitList(dataFiltered)
                            } else {
                                whistlistAdapter.submitList(whistlist)
                            }
                            return true
                        }

                        override fun onQueryTextChange(newText: String?): Boolean {
                            if (newText != null) {
                                val dataFiltered = whistlist.filter { it.nama!!.lowercase().contains(newText.lowercase())}
                                whistlistAdapter.submitList(dataFiltered)
                            } else {
                                whistlistAdapter.submitList(whistlist)
                            }
                            return true
                        }
                    })
                }
            }
        }
    }
}