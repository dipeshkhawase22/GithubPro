package com.example.githubpro.Screen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubpro.Model.Repository
import com.example.githubpro.R
import kotlinx.android.synthetic.main.list_item.view.*
import javax.security.auth.callback.Callback


class Adapter(val callback: (Repository) -> Unit): RecyclerView.Adapter<Adapter.Holder>(){

    val repos = ArrayList<Repository>()

    fun setRepositories(list: Collection<Repository>){

        repos.clear()
        repos.addAll(list)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.list_item, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return repos.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        val repository = repos.get(p1)
        p0?.itemView.title.text = repository.name
        p0?.itemView.description.text = repository.description
        p0?.itemView.stars.text = "${repository.stars.toString()}stars"

        p0?.itemView?.setOnClickListener {
            callback.invoke(repository)
        }
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view){

    }
}