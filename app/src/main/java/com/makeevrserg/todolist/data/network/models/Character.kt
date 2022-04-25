package com.makeevrserg.todolist.data.network.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose


@Entity(tableName = Character.TABLE_NAME)
data class Character(
    val created: String,
    val gender: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    @Expose
    @Embedded(prefix = "location")
    val location: Additional,
    val name: String,
    @Expose
    @Embedded(prefix = "origin")
    val origin: Additional,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    companion object {
        const val TABLE_NAME = "character"
    }
}