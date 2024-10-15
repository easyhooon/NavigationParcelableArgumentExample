package com.yijihun.navigationparcelableargumentexample.home

import com.yijihun.navigationparcelableargumentexample.model.Lecture
import com.yijihun.navigationparcelableargumentexample.model.Student
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class HomeUiState(
    val lectureList: ImmutableList<Lecture> = persistentListOf(),
    val studentList: ImmutableList<Student> = persistentListOf(),
)
