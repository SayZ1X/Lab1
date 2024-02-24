package com.example.controlwork1

import android.os.Bundle
import android.provider.MediaStore.Images
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.controlwork1.ui.theme.ControlWork1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ControlWork1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenWrapper()
                }
            }
        }
    }
}

@Composable
fun ScreenWrapper()
{
    val avatar = painterResource(R.drawable.ellipse_54)
    val phoneSetting = painterResource(R.drawable.phonelink_setup)
    val searchingTool = painterResource(R.drawable.search)
    val wifiTool = painterResource(R.drawable.wifi)
    val devices = painterResource(R.drawable.devices_other)
    val apps = painterResource(R.drawable.apps)
    val notifications = painterResource(R.drawable.notifications_none)
    val access = painterResource(R.drawable.accessibility)
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEFE3))
            .padding(start = 21.dp)
            .padding(end = 21.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Image(painter = avatar, contentDescription = null,
                modifier = Modifier
                    .size(size = 51.dp))
        }
        Row {
            Text(text = "Settings",
                fontSize = 36.sp,
                fontWeight = Bold,
                modifier = Modifier
                    .shadow(40.dp))
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFDBEA8D), shape = RoundedCornerShape(25.dp))
                .padding(
                    start = 16.dp,
                    top = 22.dp,
                    end = 16.dp,
                    bottom = 22.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = phoneSetting, contentDescription = null,
                modifier = Modifier
                    .size(size = 24.dp))
            Column (
                modifier = Modifier
                    .padding(start = 16.dp)
            ){
                Text(text = "Get to know your Pixel",
                    fontSize = 21.sp,
                    fontWeight = Medium)
                Text(text = "Explore what you can do with your phone",
                    fontSize = 14.sp,
                    fontWeight = Normal)
            }
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFCFCF7), shape = RoundedCornerShape(25.dp))
            .padding(
                start = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(painter = searchingTool, contentDescription = null,
                modifier = Modifier
                    .size(24.dp))
            Text(text = "Search Settings...",
                fontSize = 20.sp,
                fontWeight = Normal,
                modifier = Modifier
                    .padding(start = 11.dp))
        }
        Row {
            SettingItem(wifiTool, "Network & Internet", "Wi-Fi, Mobile, Data usage, Hotspot")
        }
        Row {
            SettingItem(devices, "Connected devices", "Bluetooth, Cast, NFC")
        }
        Row {
            SettingItem(apps, "App", "Permissions, default apps")
        }
        Row {
            SettingItem(notifications, "Notifications", "Permissions, dafault apps")
        }
        Row {
            SettingItem(access, "Digital wellbeing", "Screen time, app timer, bedtime schedules")
        }
    }
}

@Composable
fun SettingItem(painter: Painter, name: String, description: String)
{
    Row (
        verticalAlignment = Alignment.Top
    ){
        Box(
            modifier = Modifier
                .background(Color(0xFFE2E3D8), RoundedCornerShape(50.dp))
                .size(47.dp)
                .padding(12.dp)
        ){
            Image(painter = painter, contentDescription = null,
                modifier = Modifier
                    .size(24.dp))
        }
        Column (
            modifier = Modifier
                .padding(start = 17.dp)
        ){
            Text(text = "$name",
                fontSize = 20.sp,
                fontWeight = Medium)
            Text(text = "$description",
                fontSize = 14.sp,
                fontWeight = Normal)
        }
    }
}