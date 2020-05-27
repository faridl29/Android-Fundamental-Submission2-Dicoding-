package com.example.submission2.Rest

import com.example.submission2.Model.Search
import com.example.submission2.Model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {
    @GET("users")
    @Headers("Authorization: token a5de5fe6d4889d94474d6c5d5d46382aaba50558")
    fun getUserList() : Call<List<User>>

    @GET("users/{username}")
    @Headers("Authorization: token a5de5fe6d4889d94474d6c5d5d46382aaba50558")
    fun getDetailUser(@Path("username") username : String) : Call<User>

    @GET("users/{username}/followers")
    @Headers("Authorization: token a5de5fe6d4889d94474d6c5d5d46382aaba50558")
    fun getFollowerList(@Path("username") username : String) : Call<List<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token a5de5fe6d4889d94474d6c5d5d46382aaba50558")
    fun getFollowingList(@Path("username") username : String) : Call<List<User>>

    @GET("search/users")
    @Headers("Authorization: token a5de5fe6d4889d94474d6c5d5d46382aaba50558")
    fun searchUser(@Query("q") q : String) : Call<Search>
}