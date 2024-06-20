package com.bangkit.rextra

import android.content.Intent
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.rextra.databinding.ActivityOnboardingBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingActivity : AppCompatActivity() {

    private lateinit var mViewPager: ViewPager2
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        btnLogin = binding.btnLoginOnboarding
        btnRegister = binding.btnRegisterOnboarding

        btnLogin.setOnClickListener {
            val intent = Intent(this, AuthenticationActivity::class.java)
            intent.putExtra("fragment", "login")
            startActivity(intent)
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, AuthenticationActivity::class.java)
            intent.putExtra("fragment", "register")
            startActivity(intent)
        }

        mViewPager = findViewById(R.id.viewPager)
        mViewPager.adapter = OnboardingViewPagerAdapter(this, this)
        TabLayoutMediator(binding.pageIndicator, mViewPager) { _, _ -> }.attach()
        mViewPager.offscreenPageLimit = 1

        setSpannableText()
    }

    private fun setSpannableText() {
        val textPolicyTerms: AppCompatTextView = binding.textPolicyTerms

        val fullText = "Dengan melanjutkan, Anda setuju dengan Syarat Layanan dan Kebijakan Privasi kami."
        val spannableString = SpannableString(fullText)

        val termsStart = fullText.indexOf("Syarat Layanan")
        val termsEnd = termsStart + "Syarat Layanan".length
        val privacyStart = fullText.indexOf("Kebijakan Privasi")
        val privacyEnd = privacyStart + "Kebijakan Privasi".length

        val blueColor = ContextCompat.getColor(this, R.color.blue_300)

        spannableString.setSpan(ForegroundColorSpan(blueColor), termsStart, termsEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(ForegroundColorSpan(blueColor), privacyStart, privacyEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        textPolicyTerms.text = spannableString
    }
}
