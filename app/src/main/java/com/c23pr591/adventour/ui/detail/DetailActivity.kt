package com.c23pr591.adventour.ui.detail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.c23pr591.adventour.R
import com.c23pr591.adventour.core.data.Resource
import com.c23pr591.adventour.core.domain.model.Gunung
import com.c23pr591.adventour.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    private lateinit var reviewAdapter: ReviewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gunung = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("EXTRA_GUNUNG", Gunung::class.java)
        } else {
            intent.getParcelableExtra("EXTRA_GUNUNG")
        }

        setupOnClick()

        if (gunung != null) {
            setupData(gunung)

            viewModel.getFeedbackById(gunung.id).observe(this@DetailActivity) { feedback ->
                if (feedback != null) {
                    when (feedback) {
                        is Resource.Loading -> {
                            Log.e("DetailActivity", "getAllFeedback() Loading . . .")
                        }
                        is Resource.Success -> {
                            Log.e("DetailActivity", feedback.data.toString())
                            setupRecyclerview()
                            reviewAdapter.submitList(feedback.data)
                            Log.e("DetailActivity", feedback.data.toString())
                        }
                        is Resource.Error -> {
                            Log.e("DetailActivity", "getAllFeedback() Error")
                        }
                    }
                }
            }
        }
    }

    private fun setupData(gunung: Gunung) {
        with(binding) {
            val imageUrlDummy = "https://asset.kompas.com/crops/Vod4oaUnv0UCNEPqpmUbnMufLcA=/0x0:1800x1200/750x500/data/photo/2021/03/30/6062c10e95b4d.jpg"
            Glide.with(this@DetailActivity)
                .load(imageUrlDummy)
                .into(detailImgThumbnail)
            tvGunungName.text = gunung.nama
            tvGunungLocation.text = gunung.lokasi
            tvGunungRating.text = gunung.rating.toString()
            tvDetailDearah.text = gunung.daerah
            tvDetailMdpl.text = "${gunung.ketinggian.toString()}\nmdpl"
            tvDetailTrek.text = gunung.trek
            tvDetailJalur.text = gunung.jalur
            tvDetailBiaya.text = "Rp ${gunung.simaksi.toString()}"
            var statusFavorite = gunung.isFavorite == true
            setStatusFavorite(statusFavorite)
            buttonWhistlist.setOnClickListener {
                statusFavorite = !statusFavorite
                viewModel.setFavorite(gunung.id, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setupRecyclerview() {

        reviewAdapter = ReviewAdapter()
        with(binding.recyclerView) {
            setHasFixedSize(true)
            adapter = reviewAdapter
        }
    }

    private fun setupOnClick() {
        binding.buttonBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        binding.buttonTambahReview.setOnClickListener {
            if (binding.layoutTambahReview.visibility == View.VISIBLE) {
                binding.layoutTambahReview.visibility = View.GONE
                Glide.with(this@DetailActivity)
                    .load(R.drawable.ic_close)
                    .into(binding.buttonTambahReview)
            } else {
                binding.layoutTambahReview.visibility = View.VISIBLE
                Glide.with(this@DetailActivity)
                    .load(R.drawable.ic_add)
                    .into(binding.buttonTambahReview)
            }
        }

    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            Glide.with(this@DetailActivity)
                .load(R.drawable.ic_favorite)
                .into(binding.imgWhistlist)
        } else {
            Glide.with(this@DetailActivity)
                .load(R.drawable.ic_favorite_border)
                .into(binding.imgWhistlist)
        }
    }
}