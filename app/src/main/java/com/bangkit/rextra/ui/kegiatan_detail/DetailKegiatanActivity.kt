package com.bangkit.rextra.ui.kegiatan_detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bangkit.rextra.R
import com.bangkit.rextra.databinding.ActivityDetailKegiatanBinding
import com.bangkit.rextra.databinding.ActivityMainBinding

class DetailKegiatanActivity : AppCompatActivity() {
    companion object {
        const val DETAIL_ID = "detailId"
    }
    private val viewModel: DetailKegiatanViewModel by viewModels()
    private lateinit var binding: ActivityDetailKegiatanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailKegiatanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.rtBar.btnBack.setOnClickListener {
            onBackPressed()
            finish()
        }

        val id = intent.getStringExtra(DETAIL_ID)
        id?.let {
            viewModel.fetchDetailActivity(id)
        }
        viewModel.activity.observe(this) {
            with(binding) {
                jenisKegiatan.text = it.jenisKegiatan
                namaKegiatan.text = it.namaKegiatan
                tvIsianLokasi.text = it.lokasiKegiatan
                tvIsianDurasi.text = it.durasiKegiatan
                tvIsianPenyelenggara.text = it.penyelenggara
                tvIsianTanggal.text = it.tanggalDaftar
                tvIsianDeskripsi.text = it.deskripsiKegiatan
                tvIsiPersyaratan.text = it.syaratPendaftaran.joinToString(separator = "\n")
                tvDaftarSkill.text = it.requirementSkill.joinToString(separator = "\n")
            }
        }
    }
}