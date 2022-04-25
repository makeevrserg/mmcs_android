package com.makeevrserg.todolist.data.room

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.makeevrserg.todolist.data.network.models.Character
import com.makeevrserg.todolist.data.room.dao.TodoDao
import com.makeevrserg.todolist.data.room.entities.TodoEntity

class TodoRepository(private val dictionaryDao: TodoDao) {

    suspend fun selectAllTodos(): List<TodoEntity> = dictionaryDao.selectAllTodos()

    suspend fun insertTodo(todo: TodoEntity) = dictionaryDao.insertTodo(todo)

    suspend fun insertTodos(todo: List<TodoEntity>) = dictionaryDao.insertTodos(todo)

    suspend fun deleteTodo(todo: TodoEntity) = dictionaryDao.deleteTodo(todo)

    suspend fun updateTodo(todo: TodoEntity) = dictionaryDao.updateTodo(todo)

    suspend fun insertCharacters(characters: List<Character>) =
        dictionaryDao.insertCharacters(characters)

    suspend fun getCharacter(id: Long) = dictionaryDao.getCharacter(id)

    suspend fun getCharacters(): List<Character> = dictionaryDao.getCharacters()
}