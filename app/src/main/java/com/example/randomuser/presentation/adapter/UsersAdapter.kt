package com.example.randomuser.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.databinding.ViewHolderUserBinding
import com.example.randomuser.presentation.viewholder.UserViewHolder

class UsersAdapter: PagingDataAdapter<UserResponse, UserViewHolder>(UserDiffCallBack()) {

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val viewBinding = ViewHolderUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(viewBinding)
    }

    class UserDiffCallBack : DiffUtil.ItemCallback<UserResponse>() {
        override fun areItemsTheSame(
            oldItem: UserResponse,
            newItem: UserResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: UserResponse,
            newItem: UserResponse
        ): Boolean {
            return oldItem == newItem
        }
    }
}