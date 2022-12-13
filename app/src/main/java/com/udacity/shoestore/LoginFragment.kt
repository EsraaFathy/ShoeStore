package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    val binding: FragmentLoginBinding by lazy {
        FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


//        val navHostFragment =
//            fragmentManager?.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        val appBarConfiguration = AppBarConfiguration(
//            topLevelDestinationIds = setOf(),
//            fallbackOnNavigateUpListener = ::onSupportNavigateUp
//        )
//        activity?.findViewById<Toolbar>(R.id.toolbar)
//            ?.setupWithNavController(navController, appBarConfiguration)

        binding.loginNavFragment.setOnClickListener {
            findNavController().navigate(R.id.action_gfg_nav_to_something2)
        }



        return binding.root
    }

    private fun onSupportNavigateUp(): Boolean {
        return false
    }

}