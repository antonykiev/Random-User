package com.example.randomuser.presentation.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.databinding.ViewHolderUserBinding

class UserViewHolder(
    private val binding: ViewHolderUserBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: UserResponse?) {
        user ?: return

        binding.tvFullName.text = "${user.name.first} ${user.name.last}"
    }
}