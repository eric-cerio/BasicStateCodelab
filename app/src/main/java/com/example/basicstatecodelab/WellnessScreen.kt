package com.example.basicstatecodelab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    StatefulCounter(modifier = modifier)
    val list = remember {
        getWellnessTask().toMutableStateList()
    }
    WellnessTaskList(list = list) {
        list.remove(it)
    }
}


fun getWellnessTask() = List(30) {
    WellnessTask(it, "Task #$it")
}