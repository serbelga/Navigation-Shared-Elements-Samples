package com.example.sergiobelda.navigationsharedelements.ui.recyclerviewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.sergiobelda.navigationsharedelements.R
import com.example.sergiobelda.navigationsharedelements.ui.recyclerviewexample.dummy.DummyContent

/**
 * A simple [Fragment] subclass.
 */
class RecyclerViewFragment : Fragment() {
    private val columnCount = 2

    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewAdapter = RecyclerViewAdapter(DummyContent.ITEMS)
        recyclerViewAdapter.listener = object : RecyclerViewAdapter.ItemClickListener {
            override fun onItemClickListener(item: DummyContent.DummyItem, imageView: ImageView) {
                val extras = FragmentNavigatorExtras(
                    imageView to item.id
                )
                val action = RecyclerViewFragmentDirections.navToItemDetailFragment(id = item.id)
                findNavController().navigate(action, extras)
            }
        }
        view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = GridLayoutManager(context, columnCount)
            adapter = recyclerViewAdapter
        }
    }
}
