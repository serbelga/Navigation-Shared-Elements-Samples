package com.example.sergiobelda.navigationsharedelements


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_parent.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ParentFragment : Fragment() {
    val IMAGE_URI = "https://i.scdn.co/image/8d5eabf813797aa39f6e8186f702a1998d12fe40"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parent, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardView.setOnClickListener{
            val extras = FragmentNavigatorExtras(
                imageView to "imageView"
            )
            findNavController().navigate(R.id.detailAction, null, null, extras)
        }
        Glide.with(context!!).load(IMAGE_URI).centerCrop().into(imageView)
    }
}
