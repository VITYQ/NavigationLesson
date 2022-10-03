package com.vityq.navigationlesson

import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vityq.navigationlesson.ui.theme.NavigationLessonTheme
import androidx.compose.runtime.* // Этот импорт нужен

@Composable
fun FirstScreen(onButtonClick: (String) -> Unit) {
    var counter by rememberSaveable() {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(128.dp))
        Button(onClick = { onButtonClick("AAAAAAAAAA") }) {
            Text(text = "Go to second screen")
        }
    }
}

@Preview(widthDp = 320, heightDp = 640, showBackground = true)
@Composable
fun FirstScreenPreview() {
    NavigationLessonTheme {
        FirstScreen() {}
    }
}