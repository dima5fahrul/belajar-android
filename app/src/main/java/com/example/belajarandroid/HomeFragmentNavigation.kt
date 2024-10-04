package com.example.belajarandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.belajarandroid.databinding.FragmentHomeNavigationBinding

class HomeFragmentNavigation : Fragment() {
    private var _binding: FragmentHomeNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCategoryNavigation.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_homeFragmentNavigation_to_categoryFragmentNavigation)
        )
        binding.btnProfileNavigation.setOnClickListener { view ->
            view.findNavController()
                .navigate(R.id.action_homeFragmentNavigation_to_profileActivityNavigation)
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