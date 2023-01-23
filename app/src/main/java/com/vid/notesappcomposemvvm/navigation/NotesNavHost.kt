package com.vid.notesappcomposemvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vid.notesappcomposemvvm.screens.AddScreen
import com.vid.notesappcomposemvvm.screens.MainScreen
import com.vid.notesappcomposemvvm.screens.NoteScreen
import com.vid.notesappcomposemvvm.screens.StartScreen

sealed class NavRoute(val route: String){
    object StartScreen: NavRoute("start_screen")
    object MainScreen: NavRoute("main_screen")
    object AddScreen: NavRoute("add_screen")
    object NoteScreen: NavRoute("note_screen")
}

@Composable
fun NotesNavHost(){
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = NavRoute.StartScreen.route){
        composable(NavRoute.StartScreen.route){
            StartScreen(navController = navController)
        }
        composable(NavRoute.NoteScreen.route){
            NoteScreen(navController = navController)
        }
        composable(NavRoute.AddScreen.route){
            AddScreen(navController = navController)
        }
        composable(NavRoute.MainScreen.route){
            MainScreen(navController = navController)
        }
    }
}