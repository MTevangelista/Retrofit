package br.projeto.retrofit.services

import br.projeto.retrofit.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonServices {

    @GET("/pokemon")
    fun all(): Call<List<Pokemon>>

    @GET("/pokemon/{id}")
    fun show(@Path("id") id: Int): Call<Pokemon>
}