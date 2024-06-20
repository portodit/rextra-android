package com.bangkit.rextra.ui.gercep

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bangkit.rextra.R
import com.bangkit.rextra.databinding.ActivityRextraGercepMainBinding

class RextraMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRextraGercepMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRextraGercepMainBinding.inflate(layoutInflater)
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
        binding.btnLoginOnboarding.setOnClickListener {
            Intent(this, RextraGercepFormActivity::class.java).apply {
                startActivity(this)
                finish()
            }
        }
    }
}