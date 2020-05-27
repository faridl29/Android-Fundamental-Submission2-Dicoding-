package com.example.submission2.Views.fragment.following

import com.example.submission2.Model.User
import com.example.submission2.Views.base.View

interface FollowingView : View {
    fun onShowLoading()
    fun onHideLoading()
    fun onSuccess(result: List<User>)
    fun onError(error: String)
}