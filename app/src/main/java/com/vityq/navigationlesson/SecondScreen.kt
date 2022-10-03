package com.vityq.navigationlesson

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.vityq.navigationlesson.ui.theme.NavigationLessonTheme

@Composable
fun SecondScreen(text: String = "no args") {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "It's the second screen",
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center
        )
        Text(text = "Argument: $text")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Go to first screen")
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(widthDp = 320, heightDp = 640, showBackground = false)
@Composable
fun SecondScreenPreview() {
    NavigationLessonTheme {
        SecondScreen()
    }
}
