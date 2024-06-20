package com.bangkit.rextra.ui.gercep

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.rextra.data.request.RecommendRequest
import com.bangkit.rextra.data.response.recommendation.RecommendResult
import com.bangkit.rextra.databinding.ActivityRextraGercepFormBinding
import com.bangkit.rextra.ui.gercep.HasilRekomendasiRextraActivity.Companion.RECOMMEND_REQUEST

class RextraGercepFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRextraGercepFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRextraGercepFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAutoCompleteTextViews()
        setupButtonClickListener()
        binding.rtBar.btnBack.setOnClickListener {
            onBackPressed()
            finish()
        }
        binding.btnRextraGercepForm.setOnClickListener {
            val ptn = binding.actvAsalPtn.text.toString()
            val jenisKegiatan = binding.actvJenisKegiatan.text.toString()
            val lokasi = binding.actvLokasiKegiatan.text.toString()
            val deskripsi = binding.etDeskripsiKegiatan.text.toString()
            val pengalamanKegiatan = binding.etPengalamanKegiatan.text.toString()
            
            val requestBody = RecommendRequest(
                ptn = ptn,
                kegiatan = jenisKegiatan,
                lokasi = lokasi,
                deskripsi = deskripsi,
                kegiatanPernah = pengalamanKegiatan
            )

            binding.btnRextraGercepForm.setOnClickListener {
                navigateToResult(requestBody)
            }
        }
    }

    fun navigateToResult(q: RecommendRequest) {
        Intent(this, HasilRekomendasiRextraActivity::class.java).apply {
            putExtra(RECOMMEND_REQUEST, q)
            startActivity(this)
        }
    }

    private fun setupAutoCompleteTextViews() {
        val asalPtn = listOf("Institut Teknologi Sepuluh Nopember", "UPN Veteran Jakarta", "Institut Teknologi Bandung")
        val jenisKegiatan = listOf("UKM", "Student Chapter", "Magang", "Studi Independen", "Organisasi Luar Kampus", "Organisasi Intra Kampus", "Kepanitiaan")
        val lokasiKegiatan = listOf("Luar Kampus", "Dalam Kampus")

        binding.actvAsalPtn.setAdapter(ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, asalPtn))
        binding.actvJenisKegiatan.setAdapter(ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, jenisKegiatan))
        binding.actvLokasiKegiatan.setAdapter(ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lokasiKegiatan))
    }

    private fun setupButtonClickListener() {
        binding.btnRextraGercepForm.setOnClickListener {
            val intent = Intent(this, HasilRekomendasiRextraActivity::class.java)
            startActivity(intent)
        }
    }

}
