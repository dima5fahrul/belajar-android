package com.example.belajarandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.belajarandroid.databinding.FragmentCategoryNavigationBinding

class CategoryFragmentNavigation : Fragment() {
    private var _binding: FragmentCategoryNavigationBinding? = null
    private val binding get() = _binding!!

    companion object {
        val EXTRA_NAME = "extra_name"
        val EXTRA_STOCK = "extra_stock"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCategoryLifestyleNavigation.setOnClickListener {
            val toDetailCategoryFragmentNavigation =
                CategoryFragmentNavigationDirections.actionCategoryFragmentNavigationToDetailCategoryFragmentNavigation()
            toDetailCategoryFragmentNavigation.name = "Lifestyle"
            toDetailCategoryFragmentNavigation.stock = 7
            view.findNavController().navigate(toDetailCategoryFragmentNavigation)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}