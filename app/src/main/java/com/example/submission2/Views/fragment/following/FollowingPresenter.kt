package com.example.submission2.Views.fragment.following

import android.util.Log
import android.view.View
import com.example.submission2.Adapter.UserAdapter
import com.example.submission2.Model.User
import com.example.submission2.Rest.ApiClient
import com.example.submission2.Rest.ApiInterface
import com.example.submission2.Views.base.Presenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_followers.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingPresenter : Presenter<FollowingView> {
    private var mView: FollowingView? = null

    override fun onAttach(view: FollowingView?) {
        mView = view
    }

    override fun onDetach() {
        mView = null
    }

    fun getFollowing(username: String) {
        val mApiInterface: ApiInterface = ApiClient.providesHttpAdapter().create(ApiInterface::class.java)

        mView?.onShowLoading()
        mApiInterface.getFollowingList(username).enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                mView?.onHideLoading()
                mView?.onError(t.toString())
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                val result = response.body() ?: emptyList()
                mView?.onHideLoading()
                mView?.onSuccess(result)
            }

        })
    }

}