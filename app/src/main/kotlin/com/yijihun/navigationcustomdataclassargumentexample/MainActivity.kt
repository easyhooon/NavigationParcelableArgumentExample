package com.yijihun.navigationcustomdataclassargumentexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yijihun.navigationcustomdataclassargumentexample.ui.theme.NavigationCustomDataClassArgumentExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationCustomDataClassArgumentExampleTheme {
                MainScreen()
            }
        }
    }
}
