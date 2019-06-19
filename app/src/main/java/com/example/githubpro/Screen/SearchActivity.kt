package com.example.githubpro.Screen

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.githubpro.Network.GithubApi
import com.example.githubpro.R
import com.example.githubpro.onTextChanged
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.coroutineContext

class SearchActivity : AppCompatActivity() {

    val adapter = Adapter{repository ->
        val intent = DetailsActivity.getIntent(this, repository.name, repository.url)
        startActivity(intent)
    }
    val api: GithubApi
    var job: Job = Job()

    init {
        val retrofit =
            Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        this.api = retrofit.create(GithubApi::class.java)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        recycler_view.adapter = adapter
        search_view.onTextChanged {
            text: String -> searchGithub(text)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    fun searchGithub(text: String){
        progress.visibility = View.VISIBLE

        job.cancel()
        job = launch(CommonPool) {
            try {
                val response = api.searchRepositories(text).execute().body()

                kotlinx.coroutines.experimental.run(UI){
                    progress.visibility = View.INVISIBLE

                    val repositories = response?.repositories
                    repositories?.let {
                        adapter.setRepositories(repositories)
                    }
                }
            }
            catch (e: Throwable){
                e.printStackTrace()
            }


        }


    }
}