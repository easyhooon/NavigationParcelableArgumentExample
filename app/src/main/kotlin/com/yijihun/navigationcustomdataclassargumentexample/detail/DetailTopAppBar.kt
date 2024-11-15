package com.yijihun.navigationcustomdataclassargumentexample.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yijihun.navigationcustomdataclassargumentexample.ui.theme.NavigationParcelableArgumentExampleTheme

@Composable
fun DetailTopAppBar(
    popBackStack: () -> Unit,
    lectureName: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.White.copy(alpha = 0.8F)),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back Icon",
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    popBackStack()
                },
        )
        Text(
            text = lectureName,
        )
    }
}

@Preview
@Composable
fun DetailTopAppBarPreview() {
    NavigationParcelableArgumentExampleTheme {
        DetailTopAppBar(
            popBackStack = {},
            lectureName = "컴퓨터 구조",
        )
    }
}
