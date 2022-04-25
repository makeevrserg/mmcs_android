package com.makeevrserg.todolist.data.room.dao

import androidx.room.*
import com.makeevrserg.todolist.data.network.models.Character
import com.makeevrserg.todolist.data.room.entities.TodoEntity

@Dao
interface TodoDao {

    @Query("SELECT * FROM ${TodoEntity.TABLE_NAME}")
    suspend fun selectAllTodos(): List<TodoEntity>

    @Insert
    suspend fun insertTodo(todo: TodoEntity)

    @Insert
    suspend fun insertTodos(todo: List<TodoEntity>)

    @Delete
    suspend fun deleteTodo(todo: TodoEntity)

    @Update
    suspend fun updateTodo(todo: TodoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(characters: List<Character>)

    @Query("SELECT * FROM ${Character.TABLE_NAME} WHERE id like :id")
    suspend fun getCharacter(id: Long): Character

    @Query("SELECT * FROM ${Character.TABLE_NAME}")
    suspend fun getCharacters(): List<Character>
}