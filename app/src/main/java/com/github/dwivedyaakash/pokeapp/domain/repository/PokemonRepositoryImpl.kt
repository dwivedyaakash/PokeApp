package com.github.dwivedyaakash.pokeapp.domain.repository

import com.github.dwivedyaakash.pokeapp.data.remote.api.PokeApiService
import com.github.dwivedyaakash.pokeapp.data.remote.dto.Pokemon

class PokemonRepositoryImpl(private val api: PokeApiService) : PokemonRepository {
    override suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Result<List<Pokemon>> {
        return try {
            val response = api.getPokemonList(limit, offset)

            val pokemonList = response.pokemons.map { it ->
                val id = it.imgUrl.trimEnd('/').substringAfterLast('/')
                val imgUrl =
                    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/${id}.png"
                Pokemon(it.name.replaceFirstChar { it.uppercase() }, imgUrl)
            }

            Result.success(pokemonList)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}