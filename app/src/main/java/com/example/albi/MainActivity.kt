package com.example.albi

//Name: Tim Müller
//St. Number: 3133761

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.albi.ui.theme.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WelcomeLayout() //calling main function drawing layout
        }
    }
}

/**
 * Draws different components relevant to initial Layout
 * Arranges them in a Column placed onto a Surface
 */
@Composable
fun WelcomeLayout(){
    Surface(modifier = Modifier.fillMaxSize(),
        color = FullMango) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            GlobeImage()
            WelcomeText()
            GetStartedButton()
            InfoButton()
        }
    }
}

/**
 * Composable image of logo artwork
 * When called, draws logo to wherever it is called
 */
@Composable
fun GlobeImage(){
    val image = painterResource(R.drawable.globeartworkmedium)
    Image(painter = image, contentDescription = null)
}

/**
 * Info Button places button into a row
 * Manages local boolean value used to display or dismiss dialog
 */
@Composable
fun InfoButton() {
    val showDialog = remember { mutableStateOf(false) } //must use remember to ensure checking of value
    if (showDialog.value) { //if value is set to true, we call composable alert function
        InfoAlert(msg = stringResource(R.string.app_description),
            showDialog = showDialog.value,
            onDismiss = {showDialog.value = false})
    }
    Row(modifier = Modifier
        .padding(16.dp)
        .offset(y = 20.dp)
        .background(
            color = Color(255, 255, 255, 125),
            shape = RoundedCornerShape(50.dp)
        )
    ){
        TextButton(
            onClick = {showDialog.value = true} //flips value to true upon click
        ) {
            Text("about",
                fontFamily = FontFamily(Font(R.font.rustycage)),
                fontSize = 24.sp,
                color = Fuji)
        }
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
    Text("A.L.B.I.",
        fontFamily = FontFamily(Font(R.font.rustycage)),
        fontSize = 64.sp)

    Text("A Little Bit Interesting",
        fontFamily = FontFamily(Font(R.font.rustycage)),
        fontSize = 24.sp)
}

@Composable
fun GetStartedButton(){
    val mContext = LocalContext.current //current context needs to be saved to variable to use in onClick, since onClick is not composable
    TextButton(modifier = Modifier.padding(top = 24.dp),
        onClick = {
            mContext.startActivity(Intent(mContext, GatherActivity::class.java))
        }
    ) {
        GetStartedButtonStyle()
    }
}

@Composable
fun GetStartedButtonStyle(){
    Row(modifier = Modifier
        .padding(16.dp)
        .background(
            color = Color(255, 255, 255, 125),
            shape = RoundedCornerShape(50.dp)
        )
    ){
        Text("Get started!",
            fontFamily = FontFamily(Font(R.font.rustycage)),
            fontSize = 32.sp,
            color = Fuji,
            modifier = Modifier.padding(20.dp))
    }
}


