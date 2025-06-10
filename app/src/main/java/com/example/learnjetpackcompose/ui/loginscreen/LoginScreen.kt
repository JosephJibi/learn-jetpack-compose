package com.example.learnjetpackcompose.ui.loginscreen

import android.util.Log
import com.example.learnjetpackcompose.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learnjetpackcompose.constants.Routes

@Composable
fun LoginScreen(navController: NavController) {
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Login Image",
            modifier = Modifier.size(250.dp)
        )
        Text("Welcome Back", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Login to your account")
        // TextField(value = "", onValueChange = {})

        // Email Text Field
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(value = emailInput, onValueChange = {
            emailInput = it
        }, label = { Text("Email address") })

        // Password Text Field
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(value = passwordInput, onValueChange = {
            passwordInput = it
        }, label = { Text("Password") }, visualTransformation = PasswordVisualTransformation())


        // Login Button
        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            Log.i("Credential", "Email $emailInput, Password: $passwordInput")
            navController.navigate(Routes.homeScreen+"/"+emailInput)
        }) { Text("Login") }

        // Forgot Password button
        Spacer(Modifier.height(32.dp))
        Text("Forgot Password?", modifier = Modifier.clickable { })
        // TextButton(onClick = {}) { Text("Forgot Password?") }

        // Or sign in with button
        Spacer(Modifier.height(16.dp))
        Text("Or sign in with", modifier = Modifier.clickable { })


        // Social Media icons
        Spacer(Modifier.height(40.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {

            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { })
            Image(
                painter = painterResource(id = R.drawable.twitter),
                contentDescription = "Twitter",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { })
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Facebook",
                modifier = Modifier
                    .size(50.dp)
                    .clickable { })
        }
    }

}
