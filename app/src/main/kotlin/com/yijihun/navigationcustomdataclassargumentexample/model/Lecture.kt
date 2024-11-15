package com.yijihun.navigationcustomdataclassargumentexample.model

import kotlinx.serialization.Serializable

@Serializable
data class Lecture(
    val lectureId: Int,
    val lectureName: String,
    val professor: String,
)
