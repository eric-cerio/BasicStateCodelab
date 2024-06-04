package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SnapshotMutationPolicy
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier) {

    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }

        if(count > 0) {
            var showTask by rememberSaveable  { mutableStateOf(true) }

            if(showTask) {
                WellnessTaskItem(taskName = "Are you done with ", onClose = {

                }, modifier = modifier)
            }

            Text(
                text = "You have $count glasses.",
                modifier = modifier.padding(16.dp)
            )
        }

        Row(Modifier.padding(16.dp)) {
            Button(onClick = {count++}, Modifier.padding(16.dp), enabled = count < 10) {
                Text(text = "Add One")
            }

            Button(onClick = {count = 0}, Modifier.padding(16.dp)) {
                Text(text = "Clear")
            }
        }
    }
}


@Composable
fun StatelessCounter(count: Int, onIncrement: ()-> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if(count > 0) {
            Text(text = "YOu had $count glasses")
        } else {
            Button(onClick = onIncrement, Modifier.padding(16.dp), enabled = count < 10) {
                Text(text = "Add One")
            }
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }

    StatelessCounter(count = count, onIncrement = {count++}, modifier)
}

@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    WaterCounter(modifier = Modifier)
}
