package com.yijihun.navigationparcelableargumentexample.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yijihun.navigationparcelableargumentexample.model.Lecture
import com.yijihun.navigationparcelableargumentexample.model.Student
import com.yijihun.navigationparcelableargumentexample.ui.theme.NavigationParcelableArgumentExampleTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
fun HomeRoute(
    innerPadding: PaddingValues,
    navigateToMap: (String, Lecture, List<Student>) -> Unit,
    viewModel: ListViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        innerPadding = innerPadding,
        uiState = uiState,
        navigateToDetail = navigateToMap,
    )
}

@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    uiState: HomeUiState,
    navigateToDetail: (String, Lecture, List<Student>) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(
                count = uiState.lectureList.size,
                key = { index -> index },
            ) { index ->
                LectureItem(
                    lectureName = uiState.lectureList[index].lectureName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navigateToDetail(uiState.lectureList[index].lectureName, uiState.lectureList[index], uiState.studentList)
                        },
                )
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    thickness = 1.dp,
                    color = Color.LightGray,
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    NavigationParcelableArgumentExampleTheme {
        HomeScreen(
            innerPadding = PaddingValues(),
            uiState = HomeUiState(
                lectureList = persistentListOf(
                    Lecture(lectureId = 1, lectureName = "컴퓨터 구조", professor = "홍길동"),
                    Lecture(lectureId = 2, lectureName = "운영체제", professor = "김철수"),
                    Lecture(lectureId = 3, lectureName = "알고리즘", professor = "이영희"),
                ),
            ),
            navigateToDetail = { _, _, _ -> },
        )
    }
}
