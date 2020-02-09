package com.example.sergiobelda.navigationsharedelements.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.example.sergiobelda.navigationsharedelements.R
import kotlinx.android.synthetic.main.fragment_start.*

/**
 * A simple [Fragment] subclass.
 */
class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        single_item_button.setOnClickListener {
            findNavController().navigate(R.id.navToSingleItemExample)
        }
        recyclerview_button.setOnClickListener {
            findNavController().navigate(R.id.navToRecyclerView)
        }
    }
}
