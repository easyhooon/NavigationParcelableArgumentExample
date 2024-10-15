package com.yijihun.navigationparcelableargumentexample.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yijihun.navigationparcelableargumentexample.Route
import com.yijihun.navigationparcelableargumentexample.model.Lecture
import com.yijihun.navigationparcelableargumentexample.model.Student

fun NavGraphBuilder.homeNavGraph(
    innerPadding: PaddingValues,
    navigateToDetail: (String, Lecture, List<Student>, List<Int>) -> Unit,
) {
    composable<Route.Home> {
        HomeRoute(
            innerPadding = innerPadding,
            navigateToMap = navigateToDetail,
        )
    }
}
