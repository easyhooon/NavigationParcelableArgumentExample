package com.yijihun.navigationparcelableargumentexample.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Student(
    val studentId: Int,
    val studentName: String,
    val grade: Int,
) : Parcelable
