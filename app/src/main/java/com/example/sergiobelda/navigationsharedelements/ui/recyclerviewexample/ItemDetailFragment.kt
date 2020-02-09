package com.example.sergiobelda.navigationsharedelements.ui.recyclerviewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater

import com.example.sergiobelda.navigationsharedelements.R
import kotlinx.android.synthetic.main.fragment_item_detail.*

/**
 * A simple [Fragment] subclass.
 */
class ItemDetailFragment : Fragment() {
    private val args: ItemDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.id
        item_image.transitionName = id
        item_name.text = id
    }
}
