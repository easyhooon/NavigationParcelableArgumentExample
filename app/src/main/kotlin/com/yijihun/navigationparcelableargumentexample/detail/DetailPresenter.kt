package com.yijihun.navigationparcelableargumentexample.detail

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class DetailPresenter @AssistedInject constructor(
    @Assisted private val screen: DetailScreen,
    @Assisted private val navigator: Navigator,
) : Presenter<DetailScreen.State> {

    @Composable
    override fun present(): DetailScreen.State {
        return DetailScreen.State(
            lectureName = screen.lectureName,
            studentGradeDistribution = screen.studentGradeList.groupingBy { it }.eachCount(),
            lecture = screen.lecture,
            studentList = screen.studentList,
        ) { event ->
            when (event) {
                is DetailScreen.Event.OnBackClick -> navigator.pop()
            }
        }
    }

    @CircuitInject(DetailScreen::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen: DetailScreen,
            navigator: Navigator,
        ): DetailPresenter
    }
}
