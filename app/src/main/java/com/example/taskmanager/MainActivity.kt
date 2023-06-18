package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskCompleteImage(

                        stringResource(R.string.all_tasks_completed),
                        stringResource(R.string.nice_work)
                    )
                }
            }
        }

    }
}

@Composable
fun TaskCompleteImage(taskComplete: String, reward: String , modifier: Modifier = Modifier) {

    val image = painterResource(R.drawable.ic_task_completed)


        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

            Image(painter = image,
                modifier = Modifier,
                contentDescription = null)

            TaskCompleteText(taskComplete = taskComplete, reward = reward)

        }
}

@Composable
fun TaskCompleteText(taskComplete: String, reward: String , modifier: Modifier = Modifier){
    Text(
        text = "$taskComplete",
        modifier = Modifier,
        fontWeight = FontWeight.Bold
    )

    Text(
        text = "$reward",
        modifier = Modifier,
        fontSize = 16.sp)
}

@Preview(showBackground = true,
        showSystemUi = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TaskCompleteImage(stringResource(R.string.all_tasks_completed),
                    stringResource(R.string.nice_work)
                )
    }
}