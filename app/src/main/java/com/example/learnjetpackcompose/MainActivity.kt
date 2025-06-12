package com.example.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.learnjetpackcompose.ui.screens.learnStateManagement.LearnStateManagementModel
import com.example.learnjetpackcompose.ui.screens.learnStateManagement.LearnStateManagementScreen
import com.example.learnjetpackcompose.ui.theme.LearnJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val stateManagementModel = ViewModelProvider(this)[LearnStateManagementModel::class.java]
        enableEdgeToEdge()
        setContent {
//            AppNavigation()
            LearnStateManagementScreen(stateManagementModel)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnJetPackComposeTheme {
        Greeting("Android")
    }
}


//LearnJetPackComposeTheme {
//    Surface (modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background){
//        HomeScreen()
//    }
// Need to check difference between surface and Scaffold
////                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
////                    Greeting(
////                        name = "Android",
////                        modifier = Modifier.padding(innerPadding)
////                    )
////                }
//}