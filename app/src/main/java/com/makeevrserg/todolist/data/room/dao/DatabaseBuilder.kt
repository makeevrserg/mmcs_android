package com.makeevrserg.todolist.data.room.dao

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    fun build(context: Context) = Room.inMemoryDatabaseBuilder(
        context,
        TodoDatabase::class.java,
//        TodoDatabase.DATABASE_NAME,
    ).fallbackToDestructiveMigration().build()
}