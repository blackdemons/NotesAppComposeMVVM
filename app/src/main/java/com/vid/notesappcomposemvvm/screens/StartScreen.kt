package com.vid.notesappcomposemvvm.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vid.notesappcomposemvvm.navigation.NavRoute
import com.vid.notesappcomposemvvm.ui.theme.NotesAppComposeMVVMTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "What will we use?")
            Button(
                onClick = {
                          navController.navigate(route = NavRoute.MainScreen.route)
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 5.dp)
            ) {
                Text(text = "Room database")
            }
            Spacer(modifier = Modifier.height(5.dp))
            Button(
                onClick = {
                          navController.navigate(route = NavRoute.MainScreen.route)
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 5.dp)
            ) {
                Text(text = "Firebase database")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStartScreen() {
    NotesAppComposeMVVMTheme {
        StartScreen(navController = rememberNavController())

    }
}