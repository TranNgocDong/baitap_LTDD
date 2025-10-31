package com.example.test1112312312312.ui.demo

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimatedVisibilityDemo(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Animated Visibility") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        var showType by remember { mutableStateOf("Tĩnh") } // "Tĩnh" hoặc "Animation"

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // 🔹 Chọn loại nút
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Button(onClick = { showType = "Tĩnh" }) { Text("Nút tĩnh") }

                Button(onClick = { showType = "Animation" }) { Text("Nút animation") }
            }

            Spacer(Modifier.height(24.dp))

            // 🔹 Hiển thị theo loại đã chọn
            when (showType) {
                "Tĩnh" -> StaticContentBox()
                "Animation" -> AnimatedContentBox()
            }
        }
    }
}

// Nút tĩnh (không animation)
@Composable
fun StaticContentBox() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFBBDEFB), RoundedCornerShape(12.dp))
            .clickable { expanded = !expanded }
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = if (expanded) "Thu gọn" else "Xem thêm",
                color = Color.Black,
                style = MaterialTheme.typography.titleMedium
            )
            if (expanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    Text(
                        text = "Mục đích:\nẨn hoặc hiện các thành phần giao diện mượt mà.",
                        color = Color.DarkGray
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Ví dụ thực tế:\n- YouTube: 'Xem thêm bình luận'\n- Shopee: Thanh 'Mã giảm giá'\n- Facebook: 'Xem thêm bình luận'",
                        color = Color.DarkGray
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Ứng dụng:\nMở/ẩn thông tin chi tiết, form nhập liệu, thanh tìm kiếm, tooltip, snackbar, bottom sheet.",
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

// Nút có animation
@Composable
fun AnimatedContentBox() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFBBDEFB), RoundedCornerShape(12.dp))
            .clickable { expanded = !expanded }
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = if (expanded) "Thu gọn" else "Xem thêm",
                color = Color.Black,
                style = MaterialTheme.typography.titleMedium
            )
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn(animationSpec = tween(500)) + scaleIn(
                    initialScale = 0.8f,
                    animationSpec = tween(500)
                ),
                exit = slideOutVertically(
                    targetOffsetY = { it },
                    animationSpec = tween(400)
                ) + shrinkVertically(
                    animationSpec = tween(400)
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                ) {
                    Text(
                        text = "Mục đích:\nẨn hoặc hiện các thành phần giao diện mượt mà.",
                        color = Color.DarkGray
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Ví dụ thực tế:\n- YouTube: 'Xem thêm bình luận'\n- Shopee: Thanh 'Mã giảm giá'\n- Facebook: 'Xem thêm bình luận'",
                        color = Color.DarkGray
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Ứng dụng:\nMở/ẩn thông tin chi tiết, form nhập liệu, thanh tìm kiếm, tooltip, snackbar, bottom sheet.",
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}


