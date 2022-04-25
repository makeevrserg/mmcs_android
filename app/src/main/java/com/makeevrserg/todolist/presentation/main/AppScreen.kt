package com.makeevrserg.todolist.presentation.main

sealed class AppScreen(val route: String) {
    object TodoListScreen : AppScreen("todo_list_screen")
    object WebListScreen : AppScreen("web_list_screen")
    object WebElementScreen : AppScreen("web_element_screen")
}

