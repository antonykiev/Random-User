package com.example.randomuser.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.randomuser.R
import com.example.randomuser.databinding.FragmentUserSelectionBinding


class UserSelectionFragment: Fragment() {

    private lateinit var binding: FragmentUserSelectionBinding

    private val navController: NavController by lazy { Navigation.findNavController(binding.root) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnRandomUser.setOnClickListener(::openRandomUser)
        binding.btnUserList.setOnClickListener(::openUserList)
    }

    private fun openRandomUser(view: View) {
        navController.navigate(R.id.action_user_selection_to_randomUserFragment)
    }

    private fun openUserList(view: View) {
        navController.navigate(R.id.action_user_selection_to_userListFragment)
    }

}