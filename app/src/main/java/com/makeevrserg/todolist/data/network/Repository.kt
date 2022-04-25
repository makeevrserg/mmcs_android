package com.makeevrserg.todolist.data.network

import com.makeevrserg.todolist.application.App
import com.makeevrserg.todolist.data.network.models.Character
import com.makeevrserg.todolist.data.network.models.Characters
import com.makeevrserg.todolist.data.room.TodoRepository

class Repository(
    private var api: ClientApi = ClientApi(),
    private var todoRepository: TodoRepository = App.todoRepository
) {


    suspend fun fetchCharacters(): List<Character>? = catching {
        val list: List<Character>? = catching { api.fetchCharacters()?.results }
        if (list != null)
            todoRepository.insertCharacters(list)
        if (list.isNullOrEmpty())
            return@catching todoRepository.getCharacters()
        return@catching list
    }

    suspend fun fetchCharacter(id: Long): Character? = catching {
        catching { api.fetchCharacter(id) } ?: todoRepository.getCharacter(id)
    }
}