package com.example.githubpro.Network

import com.example.githubpro.Model.RepositoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("/search/repositories")
    fun searchRepositories(@Query("q") query: String): Call<RepositoriesResponse>
}