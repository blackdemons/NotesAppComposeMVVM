package com.vid.notesappcomposemvvm.screens

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vid.notesappcomposemvvm.MainViewModel
import com.vid.notesappcomposemvvm.MainViewModelFactory
import com.vid.notesappcomposemvvm.model.Note
import com.vid.notesappcomposemvvm.navigation.NavRoute
import com.vid.notesappcomposemvvm.ui.theme.NotesAppComposeMVVMTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val context = LocalContext.current
    val mViewModel: MainViewModel =
        viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

    val notes = mViewModel.readText.observeAsState(listOf()).value
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(NavRoute.AddScreen.route) }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Icon add",
                    tint = Color.White
                )
            }
        }) {
//            Column(modifier = Modifier.padding(innerPadding)) {
//
//
//                NoteItem(
//                    title = "Note 1",
//                    subtitle = "Subtitle for note 1",
//                    navController = navController
//                )
//                NoteItem(
//                    title = "Note 2",
//                    subtitle = "Subtitle for note 2",
//                    navController = navController
//                )
//                NoteItem(
//                    title = "Note 3",
//                    subtitle = "Subtitle for note 3",
//                    navController = navController
//                )
//                NoteItem(
//                    title = "Note 4",
//                    subtitle = "Subtitle for note 4",
//                    navController = navController
//                )
//            }
        LazyColumn{
            this.items(notes){ note ->
                NoteItem(note = note, navController = navController)
            }
        }
    }

}

@Composable
fun NoteItem(note: Note, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(NavRoute.NoteScreen.route)
            },
        elevation = cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = note.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(text = note.subtitle)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    NotesAppComposeMVVMTheme {
        MainScreen(navController = rememberNavController())
    }
}