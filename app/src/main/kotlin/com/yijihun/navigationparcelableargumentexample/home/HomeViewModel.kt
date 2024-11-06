package com.yijihun.navigationparcelableargumentexample.home

import androidx.lifecycle.ViewModel
import com.yijihun.navigationparcelableargumentexample.data.LectureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: LectureRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                lectureList = repository.getLectureList().toImmutableList(),
                studentList = repository.getStudentList().toImmutableList(),
                studentGradeList = repository.getStudentGradeList().toImmutableList()
            )
        }
    }
}
