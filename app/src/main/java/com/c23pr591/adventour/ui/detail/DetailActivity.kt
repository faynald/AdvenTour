package com.c23pr591.adventour.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.bumptech.glide.Glide
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

        val gunung = intent.getParcelableExtra<Gunung>("EXTRA_GUNUNG")

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
            tvDetailMdpl.text = gunung.ketinggian.toString()
            tvDetailTrek.text = gunung.trek
            tvDetailJalur.text = gunung.jalur
            tvDetailBiaya.text = gunung.simaksi.toString()

        }
    }

    private fun setupRecyclerview() {

        reviewAdapter = ReviewAdapter()
        with(binding.recyclerView) {
            setHasFixedSize(true)
            adapter = reviewAdapter
        }
    }
}