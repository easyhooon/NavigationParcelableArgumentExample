package com.yijihun.navigationparcelableargumentexample.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yijihun.navigationparcelableargumentexample.LectureType
import com.yijihun.navigationparcelableargumentexample.Route
import com.yijihun.navigationparcelableargumentexample.StudentListType
import com.yijihun.navigationparcelableargumentexample.model.Lecture
import com.yijihun.navigationparcelableargumentexample.model.Student
import kotlin.reflect.typeOf

fun NavController.navigateToDetail(
    lectureName: String,
    lecture: Lecture,
    studentList: List<Student>,
) {
    navigate(Route.Detail(lectureName, lecture, studentList))
}

fun NavGraphBuilder.detailNavGraph(
    innerPadding: PaddingValues,
    popBackStack: () -> Unit,
) {
    composable<Route.Detail>(
        typeMap = mapOf(
            typeOf<Lecture>() to LectureType,
            typeOf<List<Student>>() to StudentListType,
        ),
    ) {
        DetailRoute(
            innerPadding = innerPadding,
            popBackStack = popBackStack,
        )
    }
}
