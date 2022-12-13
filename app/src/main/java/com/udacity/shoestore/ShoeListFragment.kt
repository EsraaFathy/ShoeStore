package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding

class ShoeListFragment : Fragment() {


    private val binding : FragmentShoeListBinding by lazy {
        FragmentShoeListBinding.inflate(layoutInflater)
    }
    private val viewModel : ShoesViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initView()

        binding.detailsScreen.setOnClickListener {
            findNavController().navigate(R.id.action_shoe_list_nav_fragment_to_shoe_details_nav_fragment)
        }
        return binding.root
    }

    private fun initView() {
        viewModel.shoesList.value?.forEachIndexed { index, shoe ->
             val shoeItemView : ShoeItemBinding by lazy {
                ShoeItemBinding.inflate(layoutInflater)
            }

            Glide.with(requireActivity())
                .load(shoe.images[0])
                .error(R.drawable.error_image)
                .into(shoeItemView.shoeImage)

            shoeItemView.shoeTitle.text = shoe.name
            shoeItemView.shoeCompany.text = shoe.company
            binding.shoeListLinear.addView(shoeItemView.root,index)
        }
    }

}