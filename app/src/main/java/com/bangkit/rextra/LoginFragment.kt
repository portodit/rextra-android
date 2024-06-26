package com.bangkit.rextra

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.bangkit.rextra.data.response.LoginData
import com.bangkit.rextra.data.viewmodel.DataStoreViewModel
import com.bangkit.rextra.data.viewmodel.MainViewModel
import com.bangkit.rextra.data.viewmodel.MainViewModelFactory
import com.bangkit.rextra.data.viewmodel.ViewModelFactory
import com.bangkit.rextra.databinding.FragmentLoginBinding
import com.bangkit.rextra.ui.customview.CustomDialog
import com.bangkit.rextra.ui.home.HomeFragment
import com.bangkit.rextra.utils.Helper
import com.bangkit.rextra.utils.UserPreferences
import com.bangkit.rextra.MyApplication.Companion.dataStore


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: MainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory(requireContext()))[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preferences = UserPreferences.getInstance(requireContext().dataStore)
        val dataStoreViewModel =
            ViewModelProvider(this, ViewModelFactory(preferences))[DataStoreViewModel::class.java]

        dataStoreViewModel.getLoginSession().observe(viewLifecycleOwner) { sessionTrue ->
            if (sessionTrue) {
                navigateToHome()
            }
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            when {
                email.isEmpty() || password.isEmpty() -> {
                    CustomDialog(requireContext(), getString(R.string.empty_email_password), R.raw.error).show()
                }
                !Helper.isValidEmail(email) && !Helper.validateMinLength(password) -> {
                    CustomDialog(requireContext(), getString(R.string.invalid_email_password), R.raw.error).show()
                }
                !Helper.isValidEmail(email) -> {
                    CustomDialog(requireContext(), getString(R.string.invalid_email), R.raw.error).show()
                }
                !Helper.validateMinLength(password) -> {
                    CustomDialog(requireContext(), getString(R.string.invalid_password), R.raw.error).show()
                }
                else -> {
                    val requestLogin = LoginData(
                        email.trim(),
                        password.trim()
                    )
                    loginViewModel.login(requestLogin)
                }
            }
        }

        binding.btnRegister.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.auth_container, RegisterFragment(), RegisterFragment::class.java.simpleName)
            }
        }

        loginViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        loginViewModel.message.observe(viewLifecycleOwner) {
        }

        loginViewModel.isSuccess.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                val user = loginViewModel.userlogin.value
                dataStoreViewModel.saveLoginSession(true)
                user?.token?.let { dataStoreViewModel.saveToken(it) }
                navigateToHome()
            }
        }

        loginViewModel.isError.observe(viewLifecycleOwner) { isError ->
            if (isError) {
                CustomDialog(
                    requireContext(),
                    getString(R.string.error_server),
                    R.raw.error
                ).show()
            }
        }
    }

    private fun navigateToHome() {
        parentFragmentManager.commit {
            replace(R.id.nsv, HomeFragment(), HomeFragment::class.java.simpleName)
            addToBackStack(null)
        }
    }
}
