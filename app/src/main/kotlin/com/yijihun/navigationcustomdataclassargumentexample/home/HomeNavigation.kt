package com.yijihun.navigationcustomdataclassargumentexample.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yijihun.navigationcustomdataclassargumentexample.Route
import com.yijihun.navigationcustomdataclassargumentexample.model.Lecture
import com.yijihun.navigationcustomdataclassargumentexample.model.Student

fun NavGraphBuilder.homeNavGraph(
    innerPadding: PaddingValues,
    navigateToDetail: (String, List<Int>, Lecture, List<Student>) -> Unit,
) {
    composable<Route.Home> {
        HomeRoute(
            innerPadding = innerPadding,
            navigateToDetail = navigateToDetail,
        )
    }
}
