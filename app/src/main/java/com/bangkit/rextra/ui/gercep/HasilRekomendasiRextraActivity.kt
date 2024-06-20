package com.bangkit.rextra.ui.gercep

import RecomActivityAdapter
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.rextra.R
import com.bangkit.rextra.adapter.ResultActivityAdapter
import com.bangkit.rextra.data.request.RecommendRequest
import com.bangkit.rextra.databinding.ActivityHasilRekomendasiRextraBinding
import com.bangkit.rextra.ui.kegiatan_detail.DetailKegiatanActivity
import com.bangkit.rextra.ui.kegiatan_detail.DetailKegiatanActivity.Companion.DETAIL_ID


class HasilRekomendasiRextraActivity : AppCompatActivity() {
    companion object {
        const val RECOMMEND_REQUEST = "recommendRequest"
    }
    private lateinit var binding: ActivityHasilRekomendasiRextraBinding
    private val viewModel: HasilRekomendasiViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHasilRekomendasiRextraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val rvAdapter = ResultActivityAdapter {
            navigateToDetail(it.id)
        }
        binding.rtBar.btnBack.setOnClickListener {
            onBackPressed()
            finish()
        }
        binding.recyclerView.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(this@HasilRekomendasiRextraActivity)
        }
        val model = intent.getParcelableExtra(RECOMMEND_REQUEST, RecommendRequest::class.java) ?: RecommendRequest.empty()
        viewModel.fetchResult(model)

        viewModel.results.observe(this) {
            rvAdapter.addData(it)
        }

    }
    private fun navigateToDetail(id: String) {
        Intent(this, DetailKegiatanActivity::class.java).apply {
            putExtra(DETAIL_ID, id)
            startActivity(this)
        }
    }

}