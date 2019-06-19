package com.example.githubpro.Model

import com.google.gson.annotations.SerializedName

data class RepositoriesResponse (@SerializedName("items") val repositories: Collection<Repository>)