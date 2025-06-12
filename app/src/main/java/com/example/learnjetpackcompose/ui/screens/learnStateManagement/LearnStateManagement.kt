package com.example.learnjetpackcompose.ui.screens.learnStateManagement

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlin.math.log

// remember -> persist state on recomposition
// rememberSaveable -> persist state on both recomposition and configuration change (e.g. rotation)
// ViewModel and LiveData -> Hoist the state for re-usability

@Composable
fun LearnStateManagementScreen(viewModel: LearnStateManagementModel) {
    Log.i("MyLog", "Working")
    val userName by viewModel.name.observeAsState(initial = "")
    val surName by viewModel.name.observeAsState(initial = "")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Title("$userName $surName")
        InputBox(userName, handleNameChange = {
          viewModel.onUserNameUpdate(newName = it)
        })
        InputBox(surName, handleNameChange = {
            viewModel.onSurNameUpdate(newName = it)
        })
        SampleText()
    }
}

@Composable
fun Title(userName: String) {
    Log.i("MyLog", "Working 1")
    Text("Hello $userName", fontSize = 20.sp)
}

@Composable
fun InputBox(userName: String, handleNameChange: (String) -> Unit) {
    Log.i("MyLog", "Working 2")

    OutlinedTextField(value = userName, label = { Text("Enter your name") }, onValueChange = {
        handleNameChange(it)
    })
}

@Composable
fun SampleText() {
    Log.i("MyLog", "Working 3")
    Text("Sample Text")
}