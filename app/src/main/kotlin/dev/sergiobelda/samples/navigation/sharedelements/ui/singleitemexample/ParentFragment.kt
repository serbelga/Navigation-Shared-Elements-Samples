package dev.sergiobelda.samples.navigation.sharedelements.ui.singleitemexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import dev.sergiobelda.samples.navigation.sharedelements.R
import dev.sergiobelda.samples.navigation.sharedelements.databinding.FragmentParentBinding

class ParentFragment : Fragment() {
    companion object {
        const val IMAGE_URI = "https://i.scdn.co/image/8d5eabf813797aa39f6e8186f702a1998d12fe40"
    }

    private var _binding: FragmentParentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentParentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardView.setOnClickListener {
            val extras = FragmentNavigatorExtras(
                binding.imageView to "imageView"
            )
            findNavController().navigate(R.id.detailAction, null, null, extras)
        }
        Glide.with(requireContext()).load(IMAGE_URI).centerCrop().into(binding.imageView)
    }
}
