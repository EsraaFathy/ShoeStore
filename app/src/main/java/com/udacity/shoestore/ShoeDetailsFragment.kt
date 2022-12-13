package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailsFragment : Fragment() {


    private val binding : FragmentShoeDetailsBinding by lazy {
        FragmentShoeDetailsBinding.inflate(layoutInflater)
    }
    private val viewModel : ShoesViewModel by activityViewModels()

    private var shoe : Shoe = Shoe("",0.0,"","", listOf(""))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.shoesModel = shoe
        binding.addButton.setOnClickListener {
            viewModel.shoesList.value?.add(shoe)
            findNavController().navigateUp()
        }
        return binding.root
    }

}