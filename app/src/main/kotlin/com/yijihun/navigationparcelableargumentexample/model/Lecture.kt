package com.yijihun.navigationparcelableargumentexample.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Lecture(
    val lectureId: Int = 0,
    val lectureName: String = "",
    val professor: String = "",
) : Parcelable
