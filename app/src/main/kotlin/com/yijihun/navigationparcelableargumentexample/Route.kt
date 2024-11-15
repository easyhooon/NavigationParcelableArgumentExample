package com.yijihun.navigationparcelableargumentexample

import android.os.Bundle
import androidx.navigation.NavType
import com.yijihun.navigationparcelableargumentexample.model.Lecture
import com.yijihun.navigationparcelableargumentexample.model.Student
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data class Detail(
        val lectureName: String,
        val studentGradeList: List<Int>,
        val lecture: Lecture,
        val studentList: List<Student>,
    ) : Route {
        companion object {
            val typeMap = mapOf(
                typeOf<Lecture>() to LectureType,
                typeOf<List<Student>>() to StudentListType,
            )
        }
    }
}

val LectureType = object : NavType<Lecture>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Lecture? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }

    override fun parseValue(value: String): Lecture {
        return Json.decodeFromString(value)
    }

    override fun put(bundle: Bundle, key: String, value: Lecture) {
        bundle.putString(key, Json.encodeToString(Lecture.serializer(), value))
    }

    override fun serializeAsValue(value: Lecture): String {
        return Json.encodeToString(Lecture.serializer(), value)
    }
}

val StudentListType = object : NavType<List<Student>>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): List<Student>? {
        return bundle.getStringArray(key)?.map { Json.decodeFromString<Student>(it) }
    }

    override fun parseValue(value: String): List<Student> {
        return Json.decodeFromString(ListSerializer(Student.serializer()), value)
    }

    override fun put(bundle: Bundle, key: String, value: List<Student>) {
        val serializedList = value.map { Json.encodeToString(Student.serializer(), it) }.toTypedArray()
        bundle.putStringArray(key, serializedList)
    }

    override fun serializeAsValue(value: List<Student>): String {
        return Json.encodeToString(ListSerializer(Student.serializer()), value)
    }
}
