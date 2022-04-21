package com.example.randomuser.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.randomuser.databinding.FragmentRandomUserBinding
import com.example.randomuser.databinding.FragmentUserListBinding
import com.example.randomuser.presentation.viewmodel.RandomUserViewModel

class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}