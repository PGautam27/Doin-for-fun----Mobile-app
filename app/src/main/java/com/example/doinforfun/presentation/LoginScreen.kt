package com.example.doinforfun.presentation

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.doinforfun.data.remote.dto.LoginRequest
import kotlinx.coroutines.*


@OptIn(DelicateCoroutinesApi::class)
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun LoginScreen(viewModel: DoinViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val at = viewModel.at.value
    val att = viewModel.token.observeAsState()
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
        OutlinedTextField(value = email.value, onValueChange ={email.value=it}, label = { Text(text = "Phone") })
        Spacer(modifier = Modifier.padding(vertical = 20.dp))
        OutlinedTextField(value = password.value, onValueChange = {password.value = it}, label = { Text(text = "Password") })
        Button(onClick = {
            viewModel.login(LoginRequest(phone = email.value.toInt(), password = password.value))
        }) {
            Text(text = "Login")
        }

        
        Text(text = at?.token.toString(), fontSize = 20.sp)
        Spacer(modifier = Modifier.padding(20.dp))
        Text(text = att.value.toString(), fontSize = 30.sp)
        
        Text(text = viewModel.ol.observeAsState().value.toString())
        
    }
}


