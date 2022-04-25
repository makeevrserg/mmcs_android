package com.makeevrserg.todolist.data.room.dao

import androidx.room.*
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
}