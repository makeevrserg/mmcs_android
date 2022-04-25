package com.makeevrserg.todolist.data.network

import com.makeevrserg.todolist.data.network.models.Character
import com.makeevrserg.todolist.data.network.models.Characters

class WebRepository() {
    private var api: ClientApi = ClientApi()

    suspend fun fetchCharacters(): Characters? = catching { api.fetchCharacters() }
    suspend fun fetchCharacter(id: Long): Character? = catching { api.fetchCharacter(id) }
}