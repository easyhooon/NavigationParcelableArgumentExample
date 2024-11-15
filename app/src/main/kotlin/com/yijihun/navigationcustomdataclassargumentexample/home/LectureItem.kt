package com.yijihun.navigationcustomdataclassargumentexample.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yijihun.navigationcustomdataclassargumentexample.ui.theme.NavigationCustomDataClassArgumentExampleTheme

@Composable
fun LectureItem(
    lectureName: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(text = lectureName)
    }
}

@Preview
@Composable
fun LecturePreview() {
    NavigationCustomDataClassArgumentExampleTheme {
        LectureItem(
            lectureName = "컴퓨터 구조",
        )
    }
}
