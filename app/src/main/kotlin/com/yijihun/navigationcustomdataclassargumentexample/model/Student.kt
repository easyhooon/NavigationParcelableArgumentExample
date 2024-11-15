package com.yijihun.navigationcustomdataclassargumentexample.model

import kotlinx.serialization.Serializable

@Serializable
data class Student(
    val studentId: Int,
    val studentName: String,
    val grade: Int,
)
