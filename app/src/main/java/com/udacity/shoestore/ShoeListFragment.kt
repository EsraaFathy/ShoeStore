package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.bumptech.glide.Glide
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding

class ShoeListFragment : Fragment() {


    private val binding: FragmentShoeListBinding by lazy {
        FragmentShoeListBinding.inflate(layoutInflater)
    }
    private val viewModel: ShoesViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initView()

        binding.detailsScreen.setOnClickListener {
            findNavController().navigate(R.id.action_shoe_list_nav_fragment_to_shoe_details_nav_fragment)
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.options_menu, menu)
            }

            override fun onMenuItemSelected(item: MenuItem): Boolean {
                if (item.itemId == R.id.login_nav_fragment) {
                    findNavController().popBackStack()
                    findNavController().navigateUp();

                }
                return item.onNavDestinationSelected(findNavController())

            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
        return binding.root
    }

    private fun initView() {
        viewModel.shoesList.value?.forEachIndexed { index, shoe ->
            val shoeItemView: ShoeItemBinding by lazy {
                ShoeItemBinding.inflate(layoutInflater)
            }

            Glide.with(requireActivity())
                .load(shoe.images[0])
                .error(R.drawable.error_image)
                .into(shoeItemView.shoeImage)

            shoeItemView.shoeTitle.text = shoe.name
            shoeItemView.shoeCompany.text = shoe.company
            binding.shoeListLinear.addView(shoeItemView.root, index)
        }
    }

}