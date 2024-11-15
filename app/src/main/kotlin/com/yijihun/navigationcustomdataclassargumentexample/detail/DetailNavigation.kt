package com.yijihun.navigationcustomdataclassargumentexample.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yijihun.navigationcustomdataclassargumentexample.Route
import com.yijihun.navigationcustomdataclassargumentexample.model.Lecture
import com.yijihun.navigationcustomdataclassargumentexample.model.Student

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
        typeMap = Route.Detail.typeMap,
    ) {
        DetailRoute(
            innerPadding = innerPadding,
            popBackStack = popBackStack,
        )
    }
}
