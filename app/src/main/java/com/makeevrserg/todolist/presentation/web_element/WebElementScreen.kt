package com.makeevrserg.todolist.presentation.web_element

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.makeevrserg.astralearner.utils.TextSizes
import com.makeevrserg.todolist.presentation.components.Colors
import androidx.compose.material.TopAppBar
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.makeevrserg.astralearner.utils.Dimens

@Composable
fun WebElementScreen(
    navController: NavController,
    id: Long,
    viewModel: WebElementViewModel = WebElementViewModel(id)
) {
    val _character by viewModel.character.observeAsState()
    val isLoading by viewModel.isLoading.observeAsState(true)
    Scaffold(backgroundColor = Colors.colorPrimaryDark, topBar = {
        TopAppBar(backgroundColor = Colors.colorPrimaryDark, navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Colors.colorOnPrimary
                )
            }
        }, title = {
            Text(
                text = _character?.name ?: "Загрузка...",
                fontSize = TextSizes.M,
                color = Colors.colorOnPrimary
            )
        })
    }) {
        it
        if (isLoading)
            return@Scaffold Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Colors.colorSecondary)
            }
        _character?.let { character ->
            Column {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(Dimens.M),
                ) {
                    SubcomposeAsyncImage(
                        modifier = Modifier
                            .size(128.dp)
                            .clip(CircleShape),
                        model = character.image,
                        loading = {
                            CircularProgressIndicator(
                                color = Colors.colorSecondary, modifier = Modifier
                                    .size(Dimens.SXL)
                            )
                        },
                        contentDescription = ""
                    )
                    Column(
                        Modifier.height(128.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        TextItem(character.name)
                        TextItem(character.status)
                        TextItem(character.species)
                        TextItem(character.gender)
                    }
                }
            }
        }

    }

}

@Composable
fun TextItem(text: String) {
    Text(
        text = text,
        fontSize = TextSizes.M,
        color = Colors.colorOnPrimary
    )
}