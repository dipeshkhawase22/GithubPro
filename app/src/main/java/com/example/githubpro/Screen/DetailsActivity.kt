package com.example.githubpro.Screen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.githubpro.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity: AppCompatActivity() {

    companion object{

        val KEY_URL = "url"
        val KEY_TITLE = "title"

        fun getIntent(activity: Activity, title: String?, url: String?): Intent{

            val intent = Intent(activity, DetailsActivity::class.java)
            intent.putExtra(KEY_URL, url)
            intent.putExtra(KEY_TITLE, title)
            return intent

        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let{
            if (item.itemId == android.R.id.home){
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}