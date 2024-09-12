package com.example.week3_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.week3_login.ui.theme.Week3_LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week3_LoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginUi(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginUi(modifier: Modifier = Modifier) {
    // input holdit käyttäjätunnukselle ja salasanalle
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val textColor = Color(0xFF8A2BE2)

    // tekstikentän modifieri
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp),
            color = Color(0xFFFFC0CB),
        )

        // Käyttäjätunnuksen tekstikenttä
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Enter username") },
            trailingIcon = { Icon(Icons.Filled.Person, contentDescription = "User icon") },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Salasanan tekstikenttä
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter password")},
            trailingIcon = { Icon(Icons.Filled.Lock, contentDescription = "User icon") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Ei tee vielä mitään */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFC0CB),
                contentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Kirjaudu sisään")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun SimpleTextFieldPreview() {
    Week3_LoginTheme {
        LoginUi()
    }
}