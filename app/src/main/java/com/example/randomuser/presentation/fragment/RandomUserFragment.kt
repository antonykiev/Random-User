package com.example.randomuser.presentation.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.randomuser.databinding.FragmentRandomUserBinding
import com.example.randomuser.di.Injectable
import com.example.randomuser.domain.entity.User
import com.example.randomuser.presentation.viewmodel.RandomUserViewModel
import timber.log.Timber
import javax.inject.Inject

class RandomUserFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val randomUserViewModel by viewModels<RandomUserViewModel> { viewModelFactory }

    private lateinit var binding: FragmentRandomUserBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRandomUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        randomUserViewModel.randomUser.observe(viewLifecycleOwner) {
            Timber.d("USER = %s", it)
            when (it) {
                is RandomUserViewModel.State.Error -> binding.progress.visibility = View.INVISIBLE
                is RandomUserViewModel.State.Loading -> binding.progress.visibility = View.VISIBLE
                is RandomUserViewModel.State.Result -> {
                    binding.progress.visibility = View.INVISIBLE
                    setUser(it.value)
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setUser(user: User) {
        Glide.with(this)
            .load(user.picture.medium)
            .centerCrop()
            .into(binding.imgUser)
        binding.tvName.text = "${user.name.first} ${user.name.last}"
        binding.tvGender.text = user.gender
        binding.tvEmail.text = user.email
    }
}