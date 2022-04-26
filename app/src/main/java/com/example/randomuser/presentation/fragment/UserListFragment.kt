package com.example.randomuser.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.databinding.FragmentUserListBinding
import com.example.randomuser.presentation.adapter.UsersAdapter
import com.example.randomuser.presentation.viewmodel.UserListViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding

    private val userListViewModel by viewModel<UserListViewModel>()

    private val adapter by lazy { UsersAdapter() }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvUsers.adapter = adapter


        viewLifecycleOwner.lifecycleScope.launch {
            userListViewModel.loadUserList()
                .distinctUntilChanged()
                .collectLatest (::onUsersLoaded)
        }
    }

    private suspend fun onUsersLoaded(data: PagingData<UserResponse>) {
        adapter.submitData(data)
    }
}