package com.makeevrserg.todolist.data.network

import com.makeevrserg.todolist.data.network.models.Character
import com.makeevrserg.todolist.data.network.models.Characters
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    fun fetchCharacters(): Call<Characters>

    @GET("character/{id}")
    fun fetchCharacter(@Path("id") id: Long): Call<Character>
}