package com.bangkit.rextra.ui.gercep

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.bangkit.rextra.databinding.ActivityRextraGercepFormBinding

class RextraGercepFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRextraGercepFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRextraGercepFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAutoCompleteTextViews()
        setupButtonClickListener()
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