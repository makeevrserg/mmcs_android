package com.makeevrserg.todolist.presentation.main

sealed class AppScreen(val route: String) {
    object TodoListScreen : AppScreen("todo_list_screen")
    object AddTodoScreen : AppScreen("add_todo_screen")
}

