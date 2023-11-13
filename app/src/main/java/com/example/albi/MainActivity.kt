package com.example.albi

//Name: Tim Müller
//St. Number: 3133761

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeLayout()
        }
    }
}

@Composable
fun WelcomeLayout(){
    Surface(color= Color(255, 190, 40), modifier = Modifier.fillMaxSize()) {
        Column{
            GlobeImage()
            InfoButton()
            WelcomeText()
            TextButton(
                onClick = {  }
            ) {
                Text("Get Started!")
            }
        }
    }
}

@Composable
fun GlobeImage(){
    val image = painterResource(R.drawable.globeartworkmedium)
    Image(painter = image, contentDescription = null)
}

@Composable
fun InfoButton() {
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        InfoAlert(msg = stringResource(R.string.app_description),
            showDialog = showDialog.value,
            onDismiss = {showDialog.value = false})
    }
    TextButton(
        modifier = Modifier.padding(vertical = 24.dp),
        onClick = {showDialog.value = true}
    ) {
        InfoImage()
    }
}

@Composable
fun InfoImage(){
    val image = painterResource(R.drawable.infoiconverysmall)
    Image(painter = image, contentDescription = null)
}

@Composable
fun InfoAlert(msg : String, showDialog: Boolean, onDismiss: () -> Unit) {
    if (showDialog) {
        AlertDialog(
            title = { Text(msg) },
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(onClick = onDismiss ) {
                    Text("Dismiss")
                }
            },
            dismissButton = {}
        )
    }
}

@Composable
fun WelcomeText(){
    Text("ALBI\na little bit interesting")
}


