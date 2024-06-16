package com.bangkit.rextra.ui.pencarian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.rextra.databinding.FragmentPencarianBinding

class PencarianFragment : Fragment() {

    private var _binding: FragmentPencarianBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPencarianBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val query = arguments?.getString("query")

        // Use the query to fetch and display search results
        // For example, you could set up a RecyclerView with an adapter here
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
