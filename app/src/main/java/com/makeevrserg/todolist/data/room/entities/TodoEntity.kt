package com.makeevrserg.todolist.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = TodoEntity.TABLE_NAME)
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "todo")
    val todo: String,
    val completed:Boolean = false
) {
    companion object {
        const val TABLE_NAME = "todo"
    }
}