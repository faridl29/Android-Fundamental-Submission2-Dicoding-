package com.example.submission2.Views.fragment.followers

import com.example.submission2.Model.User
import com.example.submission2.Views.base.View

interface FollowersView : View {
    fun onShowLoading()
    fun onHideLoading()
    fun onSuccess(result: List<User>)
    fun onError(error: String)
}