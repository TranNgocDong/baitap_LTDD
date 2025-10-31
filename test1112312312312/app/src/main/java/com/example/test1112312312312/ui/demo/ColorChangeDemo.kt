package com.example.test1112312312312.ui.demo

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColorChangeDemo(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Color Change") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        // trạng thái bật/tắt
        //isActive là state xác định nút đang ở trạng thái "Bật" hay "Tắt".
        //remember { mutableStateOf(...) } giúp Compose ghi nhớ trạng thái qua các lần recomposition.
        var isActive by remember { mutableStateOf(false) }

        // màu nền mượt mà theo trạng thái
        val backgroundColor by animateColorAsState(
            targetValue = if (isActive) Color(0xFFFF9800) else Color(0xFF03A9F4),
            label = "backgroundColor"
        )

        // màu text để dễ đọc
        val textColor by animateColorAsState(
            targetValue = if (isActive) Color.Black else Color.White,
            label = "textColor"
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            // Nút toggle hoặc bubble chat
            Box(
                modifier = Modifier
                    .size(width = 180.dp, height = 60.dp) // hình chữ nhật giống bubble/toggle
                    .background(backgroundColor, CircleShape)
                    .clickable { isActive = !isActive },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (isActive) "Bật" else "Tắt",
                    color = textColor,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
