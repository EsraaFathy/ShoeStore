package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentOnboardingBinding


class OnboardingFragment : Fragment() {
    val binding: FragmentOnboardingBinding by lazy {
        FragmentOnboardingBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.skipButton.setOnClickListener {
            findNavController().navigate(R.id.action_to_instruction)
        }
        return binding.root
    }

}