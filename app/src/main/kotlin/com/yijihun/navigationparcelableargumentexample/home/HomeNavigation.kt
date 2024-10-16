package com.yijihun.navigationparcelableargumentexample.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yijihun.navigationparcelableargumentexample.Route
import com.yijihun.navigationparcelableargumentexample.model.Lecture
import com.yijihun.navigationparcelableargumentexample.model.Student

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
