package com.example.submission2.Views.activity.main

import com.example.submission2.Model.User
import com.example.submission2.Views.base.View

interface MainView : View {
    fun onSuccess(result: List<User>)
    fun onError(error: String)
    fun onDetailSuccess(user: User)
    fun onShowLoading()
    fun onHideLoading()
}