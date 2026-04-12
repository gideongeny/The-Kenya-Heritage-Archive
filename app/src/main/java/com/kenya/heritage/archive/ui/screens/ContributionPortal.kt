package com.kenya.heritage.archive.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
            text = "Preserve Your History",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Text(
            text = "Contribute your community's oral traditions and rare documents to the national archive.",
            style = MaterialTheme.typography.bodyMedium,
            color = androidx.compose.ui.graphics.Color.LightGray
        )

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Story Title") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = era,
            onValueChange = { era = it },
            label = { Text("Relevant Era or Year") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        OutlinedTextField(
            value = story,
            onValueChange = { story = it },
            label = { Text("The Narrative / Oral History") },
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
                "UPLOAD TO THE ARCHIVE",
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        OutlinedButton(
            onClick = { /* Handle Audio Record */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("RECORD ORAL HISTORY (AUDIO)")
        }
    }
}
