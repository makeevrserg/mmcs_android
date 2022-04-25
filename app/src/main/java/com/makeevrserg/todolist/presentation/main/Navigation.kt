package com.makeevrserg.todolist.presentation.main

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.*
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.makeevrserg.todolist.presentation.todo_list.TodoListScreen


@ExperimentalAnimationApi
private fun slideInAnimation(): (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition?) =
    { slideIntoContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(1000)) }

@ExperimentalAnimationApi
private fun slideOutAnimation(): (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition?) =
    { slideOutOfContainer(AnimatedContentScope.SlideDirection.Left, animationSpec = tween(1000)) }

@ExperimentalPagerApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun Navigation(
    navController: NavHostController,
    viewModelStoreOwner: ViewModelStoreOwner,
) {
    AnimatedNavHost(navController = navController, startDestination = AppScreen.TodoListScreen.route) {
        composable(
            route = AppScreen.TodoListScreen.route,
            enterTransition = slideInAnimation(),
            exitTransition = slideOutAnimation()
        ) {
            TodoListScreen(
                navController = navController,
            )
        }
//        composable(
//            route = AppScreen.WordEditScreen.route + "?id={id}",
//            enterTransition = slideInAnimation(),
//            exitTransition = slideOutAnimation(),
//            arguments = listOf<NamedNavArgument>(navArgument(name = "id") {
//                type = NavType.LongType
//                defaultValue = -1
//            })
//        ) {
//            val id = it.arguments?.getLong("id")
//            WordEditScreen(navController = navController, wordID = id)
//        }
    }
}

