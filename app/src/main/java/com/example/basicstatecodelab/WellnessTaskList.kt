package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember { getWellnessTask() },
    onClose: (WellnessTask) -> Unit
) {
    LazyColumn(modifier = modifier, state = rememberLazyListState()) {

        items(items = list, key = { task -> task.id}) {
            WellnessTaskItem(taskName = it.label, modifier = modifier, onClose = {onClose(it)})
        }
    }
}