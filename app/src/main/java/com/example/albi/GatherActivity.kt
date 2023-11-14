package com.example.albi

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.albi.ui.theme.Fuji
import com.example.albi.ui.theme.FullMango
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationServices


class GatherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetUserLocation(LocalContext.current)
            GatherLayout()


        }
    }
}
//A callback for receiving notifications from the FusedLocationProviderClient.
lateinit var locationCallback: LocationCallback
//The main entry point for interacting with the Fused Location Provider
lateinit var locationProvider: FusedLocationProviderClient
var userLatitude = mutableDoubleStateOf(0.0)
var userLongitude = mutableDoubleStateOf(0.0)
var userAltitude = mutableDoubleStateOf(0.0)
var userCountry = mutableStateOf("country")
var userCity = mutableStateOf("city")

@SuppressLint("MissingPermission")
@Composable
fun GetUserLocation(context: Context){
    locationProvider = remember { LocationServices.getFusedLocationProviderClient(context) }

}
@Composable
fun GatherLayout(){
    Surface(Modifier.fillMaxSize(),
        color = FullMango){
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            CurrentLocationText()
            GetFactsButton()
        }
    }
}
@Composable
fun CurrentLocationText(){
    Row(){
        Text("Your Current Location: ",
            fontFamily = FontFamily(Font(R.font.rustycage)),
            fontSize = 32.sp)
    }

    Row(){
        Column(){
            Text("Country: ",
                fontFamily = FontFamily(Font(R.font.rustycage)),
                fontSize = 22.sp)
        }
        Column(){
            Text("countryName: ",
                fontFamily = FontFamily(Font(R.font.rustycage)),
                fontSize = 22.sp)
        }
    }

    Row(){
        Column(){
            Text("City: ",
                fontFamily = FontFamily(Font(R.font.rustycage)),
                fontSize = 22.sp)
        }
        Column(){
            Text("cityName: ",
                fontFamily = FontFamily(Font(R.font.rustycage)),
                fontSize = 22.sp)
        }
    }

    Row(){
        Column(){
            Text("Latitude: ",
                fontFamily = FontFamily(Font(R.font.rustycage)),
                fontSize = 22.sp)
        }
        Column(){
            Text(userLatitude.value.toString(),
                fontFamily = FontFamily(Font(R.font.crayonworks)),
                fontSize = 22.sp)
        }
    }

    Row(){
        Column(){
            Text("Longitude: ",
                fontFamily = FontFamily(Font(R.font.rustycage)),
                fontSize = 22.sp)
        }
        Column(){
            Text(userLongitude.value.toString(),
                fontFamily = FontFamily(Font(R.font.crayonworks)),
                fontSize = 22.sp)
        }
    }

    Row(){
        Column(){
            Text("Altitude: ",
                fontFamily = FontFamily(Font(R.font.rustycage)),
                fontSize = 22.sp)
        }
        Column(){
            Text(userAltitude.value.toString(),
                fontFamily = FontFamily(Font(R.font.crayonworks)),
                fontSize = 22.sp)
        }
    }
}
@Composable
fun GetFactsButton(){
    val mContext = LocalContext.current
    TextButton(modifier = Modifier.padding(top = 24.dp),
        onClick = {
            mContext.startActivity(Intent(mContext, FactsActivity::class.java))
        }
    ) {
        GetFactsButtonStyle()
    }
}

@Composable
fun GetFactsButtonStyle(){
    Row(modifier = Modifier
        .padding(16.dp)
        .background(
            color = Color(255, 255, 255, 125),
            shape = RoundedCornerShape(50.dp)
        )
    ){
        Text("Get Facts!",
            fontFamily = FontFamily(Font(R.font.rustycage)),
            fontSize = 32.sp,
            color = Fuji,
            modifier = Modifier.padding(20.dp))
    }
}


