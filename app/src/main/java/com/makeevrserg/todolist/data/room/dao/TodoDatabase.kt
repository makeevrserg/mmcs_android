package com.makeevrserg.todolist.data.room.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.makeevrserg.todolist.data.network.models.Character
import com.makeevrserg.todolist.data.room.Converter
import com.makeevrserg.todolist.data.room.entities.TodoEntity

@TypeConverters(Converter::class)
@Database(
    entities = [TodoEntity::class, Character::class],
    version = 5,
    exportSchema = false
)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun dictionaryDao(): TodoDao

    companion object {
        const val DATABASE_NAME = "todo_room_database"
        const val NOT_EXIST_ID = 0L
    }
}

