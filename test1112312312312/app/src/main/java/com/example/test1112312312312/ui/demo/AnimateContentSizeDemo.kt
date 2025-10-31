package com.example.test1112312312312.ui.demo

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimateContentSizeDemo(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Animate Content Size") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->

        var expanded by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            // Box demo animateContentSize
            Box(
                modifier = Modifier
                    .widthIn(min = 200.dp, max = 350.dp)
                    .background(Color(0xFF6200EE), RoundedCornerShape(12.dp))
                    .clickable { expanded = !expanded }
                    .animateContentSize() //  Tự động animate khi nội dung thay đổi
                    .padding(16.dp)
            ) {
                Text(
                    text = if (expanded)
                        "Trong đây không có gì đâu thu gọn lại đi"
                    else "Nhấn để mở rộng nội dung",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}
