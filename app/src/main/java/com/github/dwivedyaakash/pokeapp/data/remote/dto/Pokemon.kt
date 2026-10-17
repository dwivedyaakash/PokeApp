package com.github.dwivedyaakash.pokeapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val name: String,
    @SerializedName("url")
    val imgUrl: String
)