package com.example.randomuser.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.randomuser.data.dto.BaseResponse
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.data.remote.api.UserList

class UserListPagingSource(private val userListApi: UserList): PagingSource<Int, UserResponse>() {

    private val startPagingIndex = 0

    override fun getRefreshKey(state: PagingState<Int, UserResponse>): Int? {
        /**
         * We need to get the previous key (or next key if previous is null) of the page
         * that was closest to the most recently accessed index.
         * Anchor position is the most recently accessed index.
         */
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserResponse> {
        val pageIndex = params.key ?: startPagingIndex
        return runCatching { userListApi.getUserUserList(pageIndex) }
            .map { it.results }
            .fold({
                LoadResult.Page(
                    data = it,
                    prevKey = if (pageIndex == startPagingIndex) null else pageIndex - 1,
                    nextKey = if (it.isEmpty()) null else pageIndex + 1
                )
            },
            { LoadResult.Error(it) }
        )
        }
}