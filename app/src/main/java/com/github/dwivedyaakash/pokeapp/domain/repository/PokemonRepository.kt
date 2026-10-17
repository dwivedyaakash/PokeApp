package com.github.dwivedyaakash.pokeapp.domain.repository

import com.github.dwivedyaakash.pokeapp.data.remote.dto.Pokemon

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int = 10, offset: Int = 0): Result<List<Pokemon>>
}