package com.github.dwivedyaakash.pokeapp.ui

import com.github.dwivedyaakash.pokeapp.data.remote.dto.Pokemon

sealed interface PokemonUiState {
    object Loading : PokemonUiState
    data class Success(val pokemonList: List<Pokemon>) : PokemonUiState
    data class Error(val message: String) : PokemonUiState
}