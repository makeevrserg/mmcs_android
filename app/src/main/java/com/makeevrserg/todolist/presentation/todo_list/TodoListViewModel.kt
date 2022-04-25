package com.makeevrserg.todolist.presentation.todo_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.makeevrserg.todolist.application.App
import com.makeevrserg.todolist.data.room.entities.TodoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.*
import kotlin.random.Random

class TodoListViewModel() : AndroidViewModel(App.instance) {
    fun onDelete(todo: TodoEntity) {
        viewModelScope.launch {
            App.todoRepository.deleteTodo(todo)
            _todoList.postValue(App.todoRepository.selectAllTodos())
        }
    }

    fun onCheckClicked(todo: TodoEntity) {
        viewModelScope.launch {
            App.todoRepository.updateTodo(todo.copy(completed = !todo.completed))
            _todoList.postValue(App.todoRepository.selectAllTodos())
        }
    }

    fun addTodo() {
        viewModelScope.launch {
            App.todoRepository.insertTodo(
                TodoEntity(
                    todo = UUID.randomUUID().toString(),
                    completed = Random.nextBoolean()
                )
            )
            _todoList.postValue(App.todoRepository.selectAllTodos())
        }
    }

    private val todoListFlow = flow {
        while (true) {
            val todos = App.todoRepository.selectAllTodos()
            emit(todos)
            kotlinx.coroutines.delay(500)
        }
    }
    private val _todoList = MutableLiveData<List<TodoEntity>>(listOf())
    val todoList: LiveData<List<TodoEntity>>
        get() = _todoList

    init {
        viewModelScope.launch(Dispatchers.IO) {
            todoListFlow.collectLatest {
                if (it != todoList.value)
                    _todoList.postValue(it)
            }
        }


    }
}