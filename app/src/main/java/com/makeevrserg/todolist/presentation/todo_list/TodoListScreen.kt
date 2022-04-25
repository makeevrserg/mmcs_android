package com.makeevrserg.todolist.presentation.todo_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavController
import com.makeevrserg.todolist.data.room.entities.TodoEntity


@Composable
fun TodoListScreen(
    navController: NavController,
    viewModel: TodoListViewModel = TodoListViewModel()
) {
    val todos by viewModel.todoList.observeAsState(initial = emptyList())
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { viewModel.addTodo() }) {
            Icon(Icons.Default.Add, "", tint = Color.Blue)
        }
    }) {
        it
        LazyColumn() {
            items(todos) { todo ->
                TodoElement(todo = todo, onCheckClicked = {
                    viewModel.onCheckClicked(todo)
                }) {
                    viewModel.onDelete(todo)

                }
            }

        }
    }
}

@Composable
fun TodoElement(
    todo: TodoEntity,
    onCheckClicked: (Boolean) -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = todo.completed, onCheckedChange = onCheckClicked)
            Text(
                text = todo.todo,
                style = if (todo.completed) TextStyle(textDecoration = TextDecoration.LineThrough) else LocalTextStyle.current
            )
        }
        IconButton(onClick = onDelete) {
            Icon(Icons.Default.Delete, "")
        }
    }


}