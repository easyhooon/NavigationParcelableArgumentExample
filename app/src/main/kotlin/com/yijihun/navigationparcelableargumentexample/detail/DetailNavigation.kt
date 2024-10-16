package com.yijihun.navigationparcelableargumentexample.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yijihun.navigationparcelableargumentexample.Route
import com.yijihun.navigationparcelableargumentexample.model.Lecture
import com.yijihun.navigationparcelableargumentexample.model.Student

fun NavController.navigateToDetail(
    lectureName: String,
    studentGradeList: List<Int>,
    lecture: Lecture,
    studentList: List<Student>,
) {
    navigate(Route.Detail(lectureName, studentGradeList, lecture, studentList))
}

fun NavGraphBuilder.detailNavGraph(
    innerPadding: PaddingValues,
    popBackStack: () -> Unit,
) {
    composable<Route.Detail>(
        typeMap = Route.Detail.DetailRouteNavTypeMap
    ) {
        DetailRoute(
            innerPadding = innerPadding,
            popBackStack = popBackStack,
        )
    }
}
