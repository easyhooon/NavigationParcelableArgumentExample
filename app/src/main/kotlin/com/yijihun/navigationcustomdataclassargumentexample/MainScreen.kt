package com.yijihun.navigationcustomdataclassargumentexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.yijihun.navigationcustomdataclassargumentexample.detail.detailNavGraph
import com.yijihun.navigationcustomdataclassargumentexample.detail.navigateToDetail
import com.yijihun.navigationcustomdataclassargumentexample.home.homeNavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            navController = navController,
            startDestination = Route.Home,
        ) {
            homeNavGraph(
                innerPadding = innerPadding,
                navigateToDetail = navController::navigateToDetail,
            )

            detailNavGraph(
                innerPadding = innerPadding,
                popBackStack = navController::popBackStack,
            )
        }
    }
}
