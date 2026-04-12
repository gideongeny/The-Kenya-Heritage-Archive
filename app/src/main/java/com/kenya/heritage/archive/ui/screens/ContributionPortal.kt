package com.kenya.heritage.archive.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kenya.heritage.archive.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContributionPortal() {
    var title by remember { mutableStateOf("") }
    var story by remember { mutableStateOf("") }
    var era by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.contribution_title),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = stringResource(R.string.contribution_desc),
            style = MaterialTheme.typography.bodyMedium,
            color = androidx.compose.ui.graphics.Color.LightGray
        )

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(stringResource(R.string.label_story_title)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = era,
            onValueChange = { era = it },
            label = { Text(stringResource(R.string.label_relevant_era)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = story,
            onValueChange = { story = it },
            label = { Text(stringResource(R.string.label_narrative)) },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            maxLines = 10
        )

        Button(
            onClick = { /* Handle Upload */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                stringResource(R.string.action_upload_archive),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        OutlinedButton(
            onClick = { /* Handle Audio Record */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.action_record_audio))
        }
    }
}
