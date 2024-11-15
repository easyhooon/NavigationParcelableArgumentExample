package com.yijihun.navigationcustomdataclassargumentexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.foundation.rememberCircuitNavigator
import com.yijihun.navigationcustomdataclassargumentexample.home.HomeScreen
import com.yijihun.navigationcustomdataclassargumentexample.ui.theme.NavigationCustomDataClassArgumentExampleTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var circut: Circuit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationCustomDataClassArgumentExampleTheme {
                val backStack = rememberSaveableBackStack(root = HomeScreen)
                val navigator = rememberCircuitNavigator(backStack)

                CircuitCompositionLocals(circut) {
                    NavigableCircuitContent(
                        navigator = navigator,
                        backStack = backStack,
                    )
                }
            }
        }
    }
}
