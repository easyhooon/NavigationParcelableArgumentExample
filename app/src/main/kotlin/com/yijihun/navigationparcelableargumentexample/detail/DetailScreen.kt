package com.yijihun.navigationparcelableargumentexample.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yijihun.navigationparcelableargumentexample.model.Lecture
import com.yijihun.navigationparcelableargumentexample.model.Student
import com.yijihun.navigationparcelableargumentexample.ui.theme.NavigationParcelableArgumentExampleTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
fun DetailRoute(
    innerPadding: PaddingValues,
    popBackStack: () -> Unit,
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    DetailScreen(
        innerPadding = innerPadding,
        uiState = uiState,
        popBackStack = popBackStack,
    )
}

@Composable
fun DetailScreen(
    innerPadding: PaddingValues,
    uiState: DetailUiState,
    popBackStack: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
        ) {
            DetailTopAppBar(
                popBackStack = popBackStack,
                lectureName = uiState.lectureName,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "강의:\n ${uiState.lecture}",
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "교수: ${uiState.lecture.professor}",
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "수강생 목록:\n ${uiState.studentList}",
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "수강색 학년 분포:\n ${uiState.studentGradeDistribution}",
            )
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    NavigationParcelableArgumentExampleTheme {
        DetailScreen(
            innerPadding = PaddingValues(),
            uiState = DetailUiState(
                lectureName = "컴퓨터 구조",
                lecture = Lecture(1, "컴퓨터 구조", "홍길동"),
                studentList = persistentListOf(
                    Student(1, "홍길동", 20),
                ),
            ),
            popBackStack = {},
        )
    }
}
