package com.yijihun.navigationcustomdataclassargumentexample.home

import com.yijihun.navigationcustomdataclassargumentexample.model.Lecture
import com.yijihun.navigationcustomdataclassargumentexample.model.Student
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class HomeUiState(
    val lectureList: ImmutableList<Lecture> = persistentListOf(),
    val studentList: ImmutableList<Student> = persistentListOf(),
    val studentGradeList: ImmutableList<Int> = persistentListOf(),
)
