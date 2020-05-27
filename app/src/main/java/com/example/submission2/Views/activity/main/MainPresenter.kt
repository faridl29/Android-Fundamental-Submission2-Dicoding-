package com.example.submission2.Views.activity.main

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.submission2.Adapter.UserAdapter
import com.example.submission2.Model.Search
import com.example.submission2.Model.User
import com.example.submission2.Rest.ApiClient
import com.example.submission2.Rest.ApiInterface
import com.example.submission2.Views.activity.detail.DetailActivity
import com.example.submission2.Views.base.Presenter
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter : Presenter<MainView> {
    private var mView: MainView? = null

    private lateinit var mApiInterface: ApiInterface
    override fun onAttach(view: MainView?) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun getData() {
        mApiInterface = ApiClient.providesHttpAdapter().create(ApiInterface::class.java)

        mView?.onShowLoading()
        mApiInterface.getUserList().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                mView?.onError(t.toString())
                mView?.onHideLoading()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                val result = response.body() ?: emptyList()
                mView?.onSuccess(result)
                mView?.onHideLoading()
            }

        })
    }


    fun getDetailUser(username : String) {
        mApiInterface.getDetailUser(username).enqueue(object : Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                mView?.onError(t.toString())
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                var result = response.body()

                val user = User (
                    result?.username ?: "",
                    result?.name ?: "",
                    result?.avatar ?: "",
                    result?.company ?: "",
                    result?.location ?: "",
                    result?.repository ?: "",
                    result?.followers ?: "",
                    result?.following ?: "",
                    result?.html_url?: ""
                )

                mView?.onDetailSuccess(user)

            }

        })
    }

    fun searchUser(user: String){
        mView?.onShowLoading()
        mApiInterface.searchUser(user).enqueue(object : Callback<Search>{
            override fun onFailure(call: Call<Search>, t: Throwable) {
                mView?.onHideLoading()
                mView?.onError(t.toString())
            }

            override fun onResponse(call: Call<Search>, response: Response<Search>) {
                val result = response.body()?.listUser ?: emptyList()
                mView?.onSuccess(result)
                mView?.onHideLoading()
            }

        })
    }

}