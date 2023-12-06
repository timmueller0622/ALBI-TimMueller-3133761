package com.example.albi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.albi.ui.theme.*

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
        color = Kent
    ) {
        Column(verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){
            FactsWelcomeText()
            Facts()
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
fun Facts(){
    FactAlert("Distances")
    FactAlert("Altitudes")
    FactAlert("Names")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactAlert(factGroup : String){
    val context = LocalContext.current
    var values = arrayOf("North Pole: ", "South Pole: ", "Equator: ", "World Wonder: ", "Hometown: ")
    var showDialog = remember { mutableStateOf(false) }
    var selectedText = remember { mutableStateOf(values[0]) }

    if (showDialog.value) { //if value is set to true, we call composable alert function
        FactAlert(msg = stringResource(R.string.app_description),
            showDialog = showDialog.value,
            onDismiss = {showDialog.value = false},
            values)
    }
        TextButton(
            onClick = { showDialog.value = true } //flips value to true upon click
        ) {
            FactButtonStyle(factGroup)
        }
}

@Composable
fun FactAlert(msg: String, showDialog: Boolean, onDismiss: () -> Unit, values: Array<String>) {
    if (showDialog) {
        AlertDialog(
            title = { Column(verticalArrangement = Arrangement.Center){
                        values.forEach{item ->
                            Row(){Text(item, fontFamily = FontFamily(Font(R.font.rustycage)), fontSize = 22.sp) }
                        }
                    }
            },
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
fun FactButtonStyle(factLabel : String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(
            color = TransWhite,
            shape = RoundedCornerShape(20.dp)
        )
    ){
        Text(factLabel,
            fontFamily = FontFamily(Font(R.font.rustycage)),
            fontSize = 28.sp,
            color = Fuji,
            modifier = Modifier.padding(20.dp))
    }
}

fun GetHeightFacts(){

}

fun GetDistanceFacts(){

}

fun GetNamesFacts(){

}

/*Row(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(color = TransWhite, shape = RoundedCornerShape(20.dp))
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded.value,
            onExpandedChange = {
                expanded.value = !expanded.value
            },
            modifier = Modifier.fillMaxWidth()
                .background(GrannySmith, RoundedCornerShape(20.dp))
        ) {
            Text(
                text = factGroup,
                fontFamily = FontFamily(Font(R.font.rustycage)),
                fontSize = 28.sp,
                color = Fuji,
                modifier = Modifier.menuAnchor()
                    .padding(16.dp)
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
                modifier = Modifier
                    .background(Color(0, 0, 0, 1), RoundedCornerShape(20.dp))
            ) {
                values.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item, fontFamily = FontFamily(Font(R.font.rustycage)), fontSize = 22.sp) },
                        onClick = {
                            selectedText.value = item
                            expanded.value = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        },
                        //modifier = Modifier.background(Fuji)
                    )
                }
            }
        }
    }*/



