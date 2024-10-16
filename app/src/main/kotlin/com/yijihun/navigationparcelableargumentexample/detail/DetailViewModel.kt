package com.yijihun.navigationparcelableargumentexample.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.yijihun.navigationparcelableargumentexample.model.Lecture
import com.yijihun.navigationparcelableargumentexample.model.Student
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableMap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.serialization.json.Json
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    companion object {
        private const val LECTURE_NAME = "lectureName"
        private const val STUDENT_GRADE_LIST = "studentGradeList"
        private const val LECTURE = "lecture"
        private const val STUDENT_LIST = "studentList"
    }

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private val name: String =
        requireNotNull(savedStateHandle.get<String>(LECTURE_NAME)) { "lectureName is required." }

    // Array<Int> 로 받으면 java.lang.ClassCastException: int[] cannot be cast to java.lang.Integer[] 에러 발생
    private val studentGradeList: List<Int> =
        requireNotNull(savedStateHandle.get<IntArray>(STUDENT_GRADE_LIST)?.toList()) { "studentGradeList is required." }

    private val lecture: Lecture =
        requireNotNull(
            savedStateHandle.get<String>(LECTURE)?.let { string ->
                Json.decodeFromString<Lecture>(string)
            },
        ) { "lecture is required." }

    private val studentList: List<Student> =
        requireNotNull(
            savedStateHandle.get<Array<String>>(STUDENT_LIST)?.let { array ->
                array.map { Json.decodeFromString<Student>(it) }
            },
        ) { "student is required." }

    init {
        Timber.d("name: $name, lecture: $lecture, studentList: $studentList")

        _uiState.update {
            it.copy(
                lectureName = name,
                lecture = lecture,
                studentList = studentList.toImmutableList(),
                studentGradeDistribution = studentGradeList.groupingBy { it }.eachCount().toImmutableMap(),
            )
        }
    }
}
