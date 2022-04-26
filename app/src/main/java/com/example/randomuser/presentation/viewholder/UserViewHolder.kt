package com.example.randomuser.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.databinding.ViewHolderUserBinding

class UserViewHolder(
    private val binding: ViewHolderUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: UserResponse?) {
        user ?: return

        Glide.with(binding.root.context)
            .load(user.picture.medium)
            .centerCrop()
            .into(binding.imgUser)
        binding.tvGender.text = user.gender
        binding.tvEmail.text = user.email

        binding.tvFullName.text = "${user.name.first} ${user.name.last}"
    }
}