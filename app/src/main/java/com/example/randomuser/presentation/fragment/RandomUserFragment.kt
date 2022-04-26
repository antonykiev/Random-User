package com.example.randomuser.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.randomuser.R
import com.example.randomuser.databinding.FragmentRandomUserBinding
import com.example.randomuser.domain.entity.User
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
            when (it) {
                is RandomUserViewModel.State.Error,
                is RandomUserViewModel.State.Loading -> {
                    binding.progress.visibility = View.INVISIBLE
                }
                is RandomUserViewModel.State.Result -> {
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