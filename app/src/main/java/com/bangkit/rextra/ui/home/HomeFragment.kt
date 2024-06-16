package com.bangkit.rextra.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit.rextra.R
import com.bangkit.rextra.databinding.FragmentHomeBinding
import com.bangkit.rextra.ui.gercep.RextraMainActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set click listener for the LinearLayout
        binding.gercep.setOnClickListener {
            startActivity(Intent(activity, RextraMainActivity::class.java))
        }

        // Set query text listener for the SearchView
        binding.homeSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
