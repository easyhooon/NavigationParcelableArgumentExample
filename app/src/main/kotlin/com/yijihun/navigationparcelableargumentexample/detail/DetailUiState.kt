package com.yijihun.navigationparcelableargumentexample.detail

import com.yijihun.navigationparcelableargumentexample.model.Lecture
import com.yijihun.navigationparcelableargumentexample.model.Student
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class DetailUiState(
    val lectureName: String = "",
    val lecture: Lecture = Lecture(0, "", ""),
    val studentList: ImmutableList<Student> = persistentListOf(),
)
