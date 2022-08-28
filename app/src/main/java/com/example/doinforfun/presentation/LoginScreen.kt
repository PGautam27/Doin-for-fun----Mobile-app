package com.example.doinforfun.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.doinforfun.data.remote.dto.LoginRequest


@Composable
fun LoginScreen(viewModel: DoinViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val at = viewModel.at.value
    val email = remember {
        mutableStateOf(String())
    }

    val password = remember {
        mutableStateOf(String())
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = email.value, onValueChange ={email.value=it}, label = { Text(text = "Email") })
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        OutlinedTextField(value = password.value, onValueChange = {password.value = it}, label = { Text(text = "Password") })
        Button(onClick = {
            if (email.value == null || password.value == null){
                Toast.makeText(context, "First fill the mail and password", Toast.LENGTH_SHORT).show()
                return@Button
            }
            else viewModel.login(LoginRequest(email = email.value, password = password.value))
        }) {
            Text(text = "Login")
        }

        if (at != null) {
            Text(text = at.token, fontSize = 20.sp)
        }
    }
}


