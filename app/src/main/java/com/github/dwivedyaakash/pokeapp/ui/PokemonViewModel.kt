package com.github.dwivedyaakash.pokeapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.dwivedyaakash.pokeapp.data.remote.NetworkModule
import com.github.dwivedyaakash.pokeapp.data.remote.dto.Pokemon
import com.github.dwivedyaakash.pokeapp.domain.repository.PokemonRepository
import com.github.dwivedyaakash.pokeapp.domain.repository.PokemonRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val repository: PokemonRepository = PokemonRepositoryImpl(NetworkModule.api)

    private val _uiState = MutableStateFlow<PokemonUiState>(PokemonUiState.Loading)
    val uiState: StateFlow<PokemonUiState> = _uiState.asStateFlow()

    init {
        fetchFirstTenPokemon()
    }

    private fun fetchFirstTenPokemon() {
        viewModelScope.launch {
            _uiState.value = PokemonUiState.Loading
            repository.getPokemonList(limit = 10, offset = 0)
                .onSuccess {
                    _uiState.value = PokemonUiState.Success(it)
                }.onFailure { exception ->
                    _uiState.value =
                        PokemonUiState.Error(exception.message ?: "An unknown error occurred.")
                }
        }
    }

}