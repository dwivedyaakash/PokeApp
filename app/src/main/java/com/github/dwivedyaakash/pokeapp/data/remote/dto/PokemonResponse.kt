package com.github.dwivedyaakash.pokeapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val count: Int,
    val next: String,
    val previous: String? = null,
    @SerializedName("results")
    val pokemons: List<Pokemon>
)