package com.yijihun.navigationcustomdataclassargumentexample.detail

import com.yijihun.navigationcustomdataclassargumentexample.model.Lecture
import com.yijihun.navigationcustomdataclassargumentexample.model.Student
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.ImmutableMap
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.persistentMapOf

data class DetailUiState(
    val lectureName: String = "",
    val lecture: Lecture = Lecture(0, "", ""),
    val studentList: ImmutableList<Student> = persistentListOf(),
    val studentGradeDistribution: ImmutableMap<Int, Int> = persistentMapOf(),
)
