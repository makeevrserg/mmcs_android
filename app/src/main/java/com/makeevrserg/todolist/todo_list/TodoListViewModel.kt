package com.makeevrserg.todolist.todo_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*
import kotlin.random.Random

data class TodoModel(
    val id: Long = 0,
    val text: String = "",
    val completed: Boolean = false
)

class TodoListViewModel(application: Application) : AndroidViewModel(application) {
    private val _todoItems = MutableLiveData<List<TodoModel>>(listOf())
    val todoItems: LiveData<List<TodoModel>>
        get() = _todoItems

    init {
        _todoItems.value = IntRange(0, 123).map {
            TodoModel(
                text = UUID.randomUUID().toString(),
                completed = Random.nextBoolean()
            )
        }
    }
}