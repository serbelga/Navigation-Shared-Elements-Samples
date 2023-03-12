package com.example.sergiobelda.navigationsharedelements.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sergiobelda.navigationsharedelements.R
import com.example.sergiobelda.navigationsharedelements.databinding.FragmentStartBinding

/**
 * A simple [Fragment] subclass.
 */
class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.singleItemButton.setOnClickListener {
            findNavController().navigate(R.id.navToSingleItemExample)
        }
        binding.recyclerviewButton.setOnClickListener {
            findNavController().navigate(R.id.navToRecyclerView)
        }
    }
}
