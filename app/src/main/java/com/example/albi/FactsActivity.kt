package com.example.albi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.albi.ui.theme.FullMango

class FactsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            FactsLayout()
        }
    }
}

@Composable
fun FactsLayout(){
    Surface(modifier = Modifier.fillMaxSize(),
        color = FullMango
    ) {
        Column(verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){
            FactsWelcomeText()
            FactButtons()
        }
    }
}

@Composable
fun FactsWelcomeText(){
    Text("Facts About Your Location: ",
        fontFamily = FontFamily(Font(R.font.rustycage)),
        fontSize = 24.sp)
}

@Composable
fun FactButtons(){
    TextButton(onClick = { }){
        Text("Distances")
    }

    TextButton(onClick = { }){
        Text("Altitudes")
    }

    TextButton(onClick = { }){
        Text("Names")
    }

    
}