package com.example.learnjetpackcompose.ui.screens.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnjetpackcompose.ui.theme.LearnJetPackComposeTheme
import com.example.learnjetpackcompose.ui.theme.LearnJetPackComposeTheme
//
//class HomeScreen {
//
//}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var isEmergencyAcive by remember { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if(isEmergencyAcive) {
    Text("EMERGENCY ACTIVE!")
            Text("Coordinates: Lat 34.00, Long 71.00 (Example)")
            Spacer(modifier=Modifier.height(16.dp)) // Add some space
            Button(onClick = {
                isEmergencyAcive = false;
            }) { Text("Resolve Emergency")}
        } else {
            Text(text = "Welcome, Emergency Responder!")
            Text(text = "Awaiting notifications...")
            Spacer(modifier=Modifier.height(16.dp)) // Add some space
            Button(onClick = {
                isEmergencyAcive = true
            }) { Text("Simulate New Emergency") }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    LearnJetPackComposeTheme() {
        HomeScreen()
    }

}

