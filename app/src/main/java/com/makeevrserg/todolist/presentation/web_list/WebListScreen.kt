package com.makeevrserg.todolist.presentation.web_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.makeevrserg.astralearner.utils.Dimens
import com.makeevrserg.astralearner.utils.TextSizes
import com.makeevrserg.todolist.presentation.components.Colors
import com.makeevrserg.todolist.presentation.components.DashedCard
import com.makeevrserg.todolist.presentation.components.RowElement
import com.makeevrserg.todolist.presentation.main.AppScreen

@Composable
fun WebListScreen(
    navController: NavController,
    viewModel: WebListViewModel = WebListViewModel()
) {
    val _characters by viewModel.characterList.observeAsState()
    val isLoading by viewModel.isLoading.observeAsState(true)
    Scaffold(
        backgroundColor = Colors.colorPrimaryDark,
        topBar = {
            TopAppBar(backgroundColor = Colors.colorPrimaryDark) {
                Text(
                    text = "RickAndMortyAPI",
                    fontSize = TextSizes.M,
                    color = Colors.colorOnPrimary
                )
            }
        }) {
        it
        if (isLoading)
            return@Scaffold Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Colors.colorSecondary)
            }
        _characters?.let { characters ->
            LazyColumn() {
                items(characters) { character ->
                    DashedCard(
                        modifier = Modifier.clickable { navController.navigate(AppScreen.WebElementScreen.route + "?id=${character.id}") },
                        title = {
                            Text(
                                text = character.name,
                                modifier = Modifier.padding(
                                    horizontal = Dimens.XS,
                                    vertical = Dimens.S
                                ),
                                fontSize = TextSizes.M,
                                color = Colors.colorOnPrimary
                            )
                        }) {
                        RowElement("Пол", character.gender)
                        RowElement("Статус", character.gender)
                        RowElement("Вид", character.species)
                        RowElement("Локация", character.location.name.trim())
                        RowElement("Происхождение", character.origin.name.trim())
                    }
                }

            }
        }

    }
}