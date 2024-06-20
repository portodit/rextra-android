package com.bangkit.rextra.ui.home

import RecomActivityAdapter
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.rextra.MainActivity
import com.bangkit.rextra.R
import com.bangkit.rextra.data.viewmodel.HomeViewModel
import com.bangkit.rextra.data.viewmodel.ViewModelFactory
import com.bangkit.rextra.databinding.FragmentHomeBinding
import com.bangkit.rextra.ui.gercep.RextraMainActivity
import com.bangkit.rextra.ui.kegiatan_detail.DetailKegiatanActivity
import com.bangkit.rextra.ui.kegiatan_detail.DetailKegiatanActivity.Companion.DETAIL_ID

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.fetchActivities()
        viewModel.fetchUser()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the Toolbar as ActionBar
        val toolbar = binding.homeToolbar as Toolbar
        val mainActivity = requireActivity() as? MainActivity
        mainActivity?.setSupportActionBar(toolbar)

        // Example of using Toolbar navigation icon
        toolbar.setNavigationOnClickListener {
            // Handle navigation click here
        }

        val rvAdapter = RecomActivityAdapter {
            navigateToDetail(it.id)
        }

        binding.rvRecomactivity.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireActivity())
        }

        viewModel.activies.observe(viewLifecycleOwner) {
            rvAdapter.addData(it)
        }

        viewModel.userData.observe(viewLifecycleOwner) {
            binding.profilName.text = it.name
        }
        // Set click listener for the LinearLayout
        binding.gercep.setOnClickListener {
            startActivity(Intent(activity, RextraMainActivity::class.java))
        }

        // Set query text listener for the SearchView
        binding.homeSearch.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    val bundle = Bundle().apply {
                        putString("query", query)
                    }
                    val navController = findNavController()
                    navController.navigate(R.id.PencarianFragment, bundle)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Handle text change if needed
                return false
            }
        })
    }
    private fun navigateToDetail(id: String) {
        Intent(requireActivity(), DetailKegiatanActivity::class.java).apply {
            putExtra(DETAIL_ID, id)
            startActivity(this)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
