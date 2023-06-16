package com.c23pr591.adventour.ui.main.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.c23pr591.adventour.R
import com.c23pr591.adventour.core.data.Resource
import com.c23pr591.adventour.core.data.local.entity.UserLoginEntity
import com.c23pr591.adventour.databinding.FragmentSettingBinding
import com.c23pr591.adventour.ui.auth.AuthActivity
import com.c23pr591.adventour.ui.main.MainActivity
import com.c23pr591.adventour.ui.main.SettingCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : Fragment(R.layout.fragment_setting) {

    private val binding: FragmentSettingBinding by viewBinding()
    private val viewModel: SettingViewModel by viewModels()
    private lateinit var callback: SettingCallback

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            viewModel.getToken().observe(viewLifecycleOwner) { userLogin ->
                if (userLogin.isNotEmpty()) {
                    viewModel.getUserData(userLogin[0].token).observe(viewLifecycleOwner) { user ->
                        if (user != null) {
                            when (user) {
                                is Resource.Loading -> {
                                    Log.e("SettingFragment", "viewModel.getUserData() Loading . . .")
                                }
                                is Resource.Success -> {
                                    Log.e("SettingFragment", "viewModel.getUserData() Success ${user.data.toString()}")
                                    Glide.with(requireContext())
                                        .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQWo3luud5KPZknLR5zdUUwzvYBztWgTxrkbA&usqp=CAU")
                                        .into(binding.imageProfile)
                                    binding.tvProfileName.text = user.data?.get(0)?.nama
                                    binding.tvProfileDomisili.text = user.data?.get(0)?.domisili
                                    binding.tvProfileUmur.text = "${user.data?.get(0)?.umur.toString()}\nTahun"
                                    binding.tvProfileTrek.text = "${user.data?.get(0)?.pengalaman.toString()}\nTrek"
                                    binding.buttonLogout.setOnClickListener {
                                        val userToken = UserLoginEntity(
                                            id = 1,
                                            token = userLogin[0].token
                                        )
                                        viewModel.deleteToken(userToken)
                                        val intent = Intent(requireContext(), AuthActivity::class.java)
                                        requireContext().startActivity(intent)
                                        callback.logout()
                                    }
                                }
                                is Resource.Error -> {
                                    Log.e("SettingFragment", "viewModel.getUserData() Error")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = context as MainActivity
    }
}