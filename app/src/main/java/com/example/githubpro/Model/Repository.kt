package com.example.githubpro.Model

import android.content.ClipDescription
import com.google.gson.annotations.SerializedName
import java.io.FileDescriptor

data class Repository (val name : String?,
                       val description: String?,
                       @SerializedName("html_url") val url: String?,
                       @SerializedName("stargazers_count") val stars: Int?)