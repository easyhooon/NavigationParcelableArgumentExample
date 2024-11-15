package com.yijihun.navigationcustomdataclassargumentexample.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.retained.produceRetainedState
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yijihun.navigationcustomdataclassargumentexample.data.LectureRepository
import com.yijihun.navigationcustomdataclassargumentexample.detail.DetailScreen
import com.yijihun.navigationcustomdataclassargumentexample.model.Lecture
import com.yijihun.navigationcustomdataclassargumentexample.model.Student
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class HomePresenter @AssistedInject constructor(
    private val repository: LectureRepository,
    @Assisted private val navigator: Navigator,
) : Presenter<HomeScreen.State> {

    @Composable
    override fun present(): HomeScreen.State {
        val lectureList by produceRetainedState<List<Lecture>>(initialValue = emptyList()) {
            value = repository.getLectureList()
        }

        val studentList by produceRetainedState<List<Student>>(initialValue = emptyList()) {
            value = repository.getStudentList()
        }

        val studentGradeList by produceRetainedState<List<Int>>(initialValue = emptyList()) {
            value = repository.getStudentGradeList()
        }

        return HomeScreen.State(
            lectureList = lectureList,
            studentList = studentList,
            studentGradeList = studentGradeList,
        ) { event ->
            when (event) {
                is HomeScreen.Event.OnLectureClick -> navigator.goTo(
                    DetailScreen(
                        lectureName = event.lectureName,
                        studentGradeList = event.studentGradeList,
                        lecture = event.lecture,
                        studentList = event.studentList,
                    ),
                )
            }
        }
    }

    @CircuitInject(HomeScreen::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(navigator: Navigator): HomePresenter
    }
}
