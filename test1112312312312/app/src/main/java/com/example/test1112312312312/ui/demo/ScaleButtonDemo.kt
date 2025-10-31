package com.example.test1112312312312.ui.demo

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaleButtonDemo(onBack: () -> Unit) {
    val scope = rememberCoroutineScope()
    val scale = remember { Animatable(1f) }

    Scaffold(
        //Thanh Tiêu Đề cùng nút quay lại
        topBar = {
            TopAppBar(
                title = { Text("Scale Animation") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            //  Mô tả
            Text(
                text = """
                    Cảm giác:
                    Nút phóng to nhanh, sau đó đàn hồi nhẹ lại – tự nhiên và sống động.
                """.trimIndent(),
                fontSize = 14.sp,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Nút bình thường (chưa animation)
            Button(
                onClick = { /* Chưa animation */ },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("❤️ Tap me", fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Nút có animation
            Button(
                onClick = {
                    scope.launch {
                        // Khi nhấn, chạy animation phóng to rồi đàn hồi lại
                        scale.animateTo(
                            //có độ phóng to khoảng 100ms có nghĩa là 0.1s nó sẽ phóng to ra
                            targetValue = 1.3f,
                            animationSpec = tween(durationMillis = 100)
                        )
                        scale.animateTo(
                            //có độ phóng khoảng 150ms có nghĩa là 0.15 nó sẽ trở lại ban đầu
                            targetValue = 1f,
                            animationSpec = tween(durationMillis = 150)
                        )
                    }
                },
                modifier = Modifier
                    .graphicsLayer(
                        scaleX = scale.value,
                        scaleY = scale.value
                    )
                    .padding(8.dp)
            ) {
                Text("❤️ Tap me", fontWeight = FontWeight.Bold)
            }
        }
    }
}
