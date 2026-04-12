package com.kenya.heritage.archive.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Privacy Policy") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp)
        ) {
            Text(
                "The Kenya Heritage Archive",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            PrivacySection(
                title = "1. Introduction",
                content = "The Kenya Heritage Archive is dedicated to preserving and celebrating Kenyan history. This Privacy Policy describes how we handle information in our application."
            )
            
            PrivacySection(
                title = "2. Data Collection",
                content = "Our app is primarily an educational experience. We do not collect personal information such as names, email addresses, or phone numbers. All historical media is streamed from our public GitHub repository."
            )
            
            PrivacySection(
                title = "3. Permissions",
                content = "The app may request Internet access to stream archival media. We do not use your location, contacts, or internal storage for data harvesting."
            )
            
            PrivacySection(
                title = "4. Data Security",
                content = "We use secure HTTPS protocols to stream content from GitHub. No user data is transmitted to third-party servers for advertising or tracking purposes."
            )
            
            PrivacySection(
                title = "5. Children's Privacy",
                content = "This app is intended for all ages. We do not knowingly collect personal information from children under 13."
            )
            
            PrivacySection(
                title = "6. Contact Us",
                content = "If you have any questions about this Privacy Policy, please contact the developer via the official GitHub repository."
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                "Last Updated: April 2026",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun PrivacySection(title: String, content: String) {
    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        Text(
            title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            content,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
