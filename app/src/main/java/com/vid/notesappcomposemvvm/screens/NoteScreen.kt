package com.vid.notesappcomposemvvm.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
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
import com.vid.notesappcomposemvvm.ui.theme.NotesAppComposeMVVMTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(navController: NavHostController){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Card(onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)) {
                Column(modifier = Modifier.padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Title")
                        Text(text = "Subtitle")
                }

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNoteScreen(){
    NotesAppComposeMVVMTheme {
        NoteScreen(navController = rememberNavController())
    }
}