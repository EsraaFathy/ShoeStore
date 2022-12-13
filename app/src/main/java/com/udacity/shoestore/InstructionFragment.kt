package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {


    private val binding : FragmentInstructionBinding by lazy {
        FragmentInstructionBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding.skipButton.setOnClickListener {
            findNavController().navigate(R.id.action_instruction_nav_fragment_to_shoe_list_nav_fragment)
        }
        return binding.root
    }

}