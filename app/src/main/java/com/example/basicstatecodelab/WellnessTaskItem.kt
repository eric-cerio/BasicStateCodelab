package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.ui.theme.BasicStateCodelabTheme

@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier= modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1F)
                .padding(16.dp),
            text = taskName
        )
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        IconButton(onClick = onClose) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Close")
        }
    }
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier
) {
    var checked by rememberSaveable {
        mutableStateOf(false)
    }

    WellnessTaskItem(taskName = taskName, checked = checked, onCheckedChange = { newValue ->
        checked = newValue
    }, onClose = {
        onClose() }, modifier)


}


@Preview(showBackground = true)
@Composable
fun WellnessTaskItemPreview() {
    BasicStateCodelabTheme {
        WellnessTaskItem(taskName = "This is a task", false, {},onClose = {})
    }
}