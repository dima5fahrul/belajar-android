package com.example.belajarandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.belajarandroid.databinding.FragmentDetailCategoryNavigationBinding

class DetailCategoryFragmentNavigation : Fragment() {
    private var _binding: FragmentDetailCategoryNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailCategoryNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataName = DetailCategoryFragmentNavigationArgs.fromBundle(arguments as Bundle).name
        val dataStock = DetailCategoryFragmentNavigationArgs.fromBundle(arguments as Bundle).stock

        binding.tvCategoryName.text = dataName
        binding.tvCategoryDescription.text = dataStock.toString()

        binding.btnHome.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragmentNavigation_to_homeFragmentNavigation)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}