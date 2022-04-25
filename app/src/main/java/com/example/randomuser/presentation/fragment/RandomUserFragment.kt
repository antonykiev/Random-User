package com.example.randomuser.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.randomuser.databinding.FragmentRandomUserBinding
import com.example.randomuser.presentation.viewmodel.RandomUserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RandomUserFragment : Fragment() {

    private lateinit var binding: FragmentRandomUserBinding

    private val randomUserViewModel by viewModel<RandomUserViewModel>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRandomUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        randomUserViewModel.randomUser.observe(viewLifecycleOwner) {
            binding.progress.visibility = View.INVISIBLE
            Log.e("randomuser", it.toString())
        }
    }
}