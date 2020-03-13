package br.projeto.retrofit.services

import br.projeto.retrofit.model.Pokemon
import br.projeto.retrofit.model.Pokemons
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonServices {
    @GET("api/v2/pokemon?limit=1000")
    fun all(): Call<Pokemons>

//    @GET("api/v2/pokemon?limit=1000")
//    fun all(count: Int): Call<Pokemons>

    @GET("api/v2/pokemon/{name}")
    fun show(@Path("name") name: Int): Call<Pokemon>
}